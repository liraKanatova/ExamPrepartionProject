package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.model.Course;
import peaksoft.model.Lesson;

import java.util.List;

public class LessonRepositoryImpl implements LessonRepository,AutoCloseable{
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveLesson(Long id,Lesson lesson) {
            entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        lesson.setCourse(course);
        entityManager.persist(lesson);
            entityManager.getTransaction().commit();
            entityManager.close();
            return lesson+" successfully saved!";

    }
    @Override
    public Lesson updateLesson(Long id, Lesson newLesson) {

            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.getReference(Lesson.class, id);
            lesson.setName(newLesson.getName());
            lesson.setVideoLink(newLesson.getVideoLink());
            lesson.setCourse(newLesson.getCourse());
            lesson.setTasks(newLesson.getTasks());
            entityManager.merge(lesson);
            entityManager.getTransaction().commit();
            entityManager.close();
            return lesson;
    }
    @Override
    public Lesson getLessonById(Long lessonId) {
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            entityManager.getTransaction().commit();
            entityManager.close();
            return lesson;
    }

    @Override
    public List<Lesson>  getLessonsByCourseId(Long courseId) {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            entityManager.getTransaction().commit();
            entityManager.close();
            return course.getLessons();
    }

    @Override
    public void close() throws Exception {

    }
}
