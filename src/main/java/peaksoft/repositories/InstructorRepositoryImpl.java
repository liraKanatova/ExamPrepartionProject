package peaksoft.repositories;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.model.Course;
import peaksoft.model.Instructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository ,AutoCloseable{
    private final EntityManager entityManager = HibernateConfig.getEntityManager();

    @Override
    public String saveInstructor(Instructor instructor) {
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            return " successfully saved!";
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor newInstructor) {
            entityManager.getTransaction().begin();
            Instructor instructor1 = entityManager.getReference(Instructor.class, id);
            instructor1.setFirstName(newInstructor.getFirstName());
            instructor1.setLastName(newInstructor.getLastName());
            instructor1.setEmail(newInstructor.getEmail());
            instructor1.setPhoneNumber(newInstructor.getPhoneNumber());
            instructor1.setCourses(newInstructor.getCourses());
            entityManager.merge(instructor1);
            entityManager.getTransaction().commit();
            entityManager.close();
            return instructor1;

    }

    @Override
    public Instructor getInstructorById(Long id) {
            entityManager.getTransaction().begin();
            Instructor instructor1 = entityManager.getReference(Instructor.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return instructor1;

    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long id) {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, id);
            entityManager.getTransaction().commit();
            entityManager.close();
            return course.getInstructors();
    }

    @Override
    public String deleteInstructorById(Long id) {
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, id);
            entityManager.remove(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            return " Successfully deleted!";
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            Course course = entityManager.find(Course.class, courseId);
            List<Instructor>instructors=new ArrayList<>(Arrays.asList(instructor));
            List<Course>courses=new ArrayList<>(Arrays.asList(course));
            course.setInstructors(instructors);
            instructor.setCourses(courses);
            entityManager.merge(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();

    }

    @Override
    public void close() throws Exception {

    }
}