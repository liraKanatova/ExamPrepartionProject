package peaksoft.services;

import peaksoft.model.Task;

import java.util.List;

public interface TaskService {
    String saveTask(Long id,Task task);
    Task updateTask(Long id,Task newTask);
    List<Task> getAllTaskByLessonId(Long lessonId);
    String deleteTaskById(Long id);

}
