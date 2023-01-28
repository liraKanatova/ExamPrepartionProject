package peaksoft.services;

import peaksoft.model.Task;
import peaksoft.repositories.TaskRepository;
import peaksoft.repositories.TaskRepositoryImpl;

import java.util.List;

public class TaskServiceImpl implements TaskService{
    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    public String saveTask(Long id,Task task) {
        taskRepository.saveTask(id, task);
        return task+ " successfully saved!";
    }

    @Override
    public Task updateTask(Long id, Task newTask) {
        return taskRepository.updateTask(id, newTask);
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
        return taskRepository.getAllTaskByLessonId(lessonId);
    }

    @Override
    public String deleteTaskById(Long id) {
        taskRepository.deleteTaskById(id);
        return "Successfully deleted!";
    }
}
