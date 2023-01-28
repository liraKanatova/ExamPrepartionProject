package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.model.Course;
import peaksoft.model.Instructor;

import java.util.List;

public class CourseRepositoryImpl implements CourseRepository,AutoCloseable {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveCourse(Course course) {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            return " successfully saved!";
    }
    @Override
    public Course getCourseById(Long courseId) {
            entityManager.getTransaction().begin();
            Course course = entityManager.createQuery("select c from Course c where c.id=:id", Course.class).setParameter("id",courseId).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return course;
    }

    @Override
    public List<Course> getAllCoursecraeteAt(String ascOrDesc) {
            entityManager.getTransaction().begin();
            switch (ascOrDesc) {
                case "asc" -> {
                    List<Course> resultList1 = entityManager.createQuery("select c from Course c order by craeteAt").getResultList();
                    return resultList1;
                }
                case "desc" -> {
                    List<Course> resultList2 = entityManager.createQuery("select c from Course c order by craeteAt desc ").getResultList();
                    return resultList2;
                }
            }
            entityManager.getTransaction().commit();
            entityManager.close();
            return null;
    }

    @Override
    public Course updateCourse(Long id, Course newCourse) {
            entityManager.getTransaction().begin();
            Course course = entityManager.getReference(Course.class, id);
            course.setCourseName(newCourse.getCourseName());
            course.setDuration(newCourse.getDuration());
            course.setCraeteAt(newCourse.getCraeteAt());
            course.setImageLink(newCourse.getImageLink());
            course.setDescription(newCourse.getDescription());
            course.setLessons(newCourse.getLessons());
            course.setInstructors(newCourse.getInstructors());
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            return course;
    }

    @Override
    public String deleteCourseById(Long id) {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, id);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            return " Successfully deleted!";
    }

    @Override
    public Course getCourseByName(String name) {
            entityManager.getTransaction().begin();
            Course name1 = entityManager.createQuery("select c from Course c where c.courseName = :name", Course.class).setParameter("name", name).getSingleResult();
            entityManager.getTransaction().commit();
            entityManager.close();
            return name1;
    }

    @Override
    public void close() throws Exception {

    }
}