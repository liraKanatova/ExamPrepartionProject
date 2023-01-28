package peaksoft.repositories;

import peaksoft.model.Course;
import peaksoft.model.Lesson;

import java.util.List;

public interface LessonRepository {
    String saveLesson(Long id,Lesson lesson);
    Lesson updateLesson(Long id,Lesson newLesson);
    Lesson getLessonById(Long lessonId);
   List<Lesson> getLessonsByCourseId(Long courseId);
}
