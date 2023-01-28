package peaksoft.repositories;

import peaksoft.model.Course;
import peaksoft.model.Task;

import java.util.List;

public interface TaskRepository {
    String saveTask(Long id,Task task);
    Task updateTask(Long id,Task newTask);
    List<Task> getAllTaskByLessonId(Long lessonId);
     String deleteTaskById(Long id);
}
