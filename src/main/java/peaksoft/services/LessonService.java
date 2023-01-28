package peaksoft.services;

import peaksoft.model.Lesson;

public interface LessonService {
    String saveLesson(Long id,Lesson lesson);
    Lesson updateLesson(Long id,Lesson newLesson);
    Lesson getLessonById(Long lessonId);
    Lesson  getLessonsByCourseId(Long courseId);
}
