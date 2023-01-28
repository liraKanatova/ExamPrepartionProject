package peaksoft.services;

import peaksoft.model.Lesson;
import peaksoft.repositories.LessonRepository;
import peaksoft.repositories.LessonRepositoryImpl;

public class LessonServiceImpl implements LessonService{
    LessonRepository lessonRepository = new LessonRepositoryImpl();
    @Override
    public String saveLesson(Long id,Lesson lesson) {
        lessonRepository.saveLesson(id, lesson);
        return lesson+ " successfully saved!";
    }

    @Override
    public Lesson updateLesson(Long id, Lesson newLesson) {
        return lessonRepository.updateLesson(id, newLesson);
    }

    @Override
    public Lesson getLessonById(Long lessonId) {
        return lessonRepository.getLessonById(lessonId);
    }

    @Override
    public Lesson getLessonsByCourseId(Long courseId) {
        return lessonRepository.getLessonById(courseId);
    }
}
