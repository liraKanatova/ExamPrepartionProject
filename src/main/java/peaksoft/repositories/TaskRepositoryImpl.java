package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.model.Lesson;
import peaksoft.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository,AutoCloseable{
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveTask(Long id,Task task) {
            entityManager.getTransaction().begin();
            List<Task>tasks=new ArrayList<>();
        Lesson lesson = entityManager.find(Lesson.class, id);
        tasks.addAll(lesson.getTasks());
        tasks.add(task);
        lesson.setTasks(tasks);
        entityManager.persist(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            return task+" successfully saved!";
    }
    @Override
    public Task updateTask(Long id, Task newTask) {
            entityManager.getTransaction().begin();
            Task task = entityManager.getReference(Task.class, id);
            task.setName(newTask.getName());
            task.setDeadLine(newTask.getDeadLine());
            task.setTask(newTask.getTask());
            entityManager.merge(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            return task;
    }
    @Override
    public List<Task> getAllTaskByLessonId(Long lessonId) {
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            entityManager.getTransaction().commit();
            entityManager.close();
            return lesson.getTasks();
    }
    @Override
    public String deleteTaskById(Long id) {

            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, id);
            entityManager.remove(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            return "Successfully deleted!";
    }

    @Override
    public void close() throws Exception {

    }
}
