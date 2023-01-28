package peaksoft.services;

import peaksoft.model.Instructor;
import peaksoft.repositories.InstructorRepository;
import peaksoft.repositories.InstructorRepositoryImpl;

import java.util.List;

public class InstructorServiceImpl implements InstructorService{
    InstructorRepository instructorRepository = new InstructorRepositoryImpl();
    @Override
    public String saveInstructor(Instructor instructor) {
        instructorRepository.saveInstructor(instructor);
        return " successfully saved!";
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor newInstructor) {
        return instructorRepository.updateInstructor(id, newInstructor);
    }

    @Override
    public Instructor getInstructorById( Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long id) {
        return instructorRepository.getInstructorsByCourseId(id);
    }

    @Override
    public String deleteInstructorById(Long id) {
        instructorRepository.deleteInstructorById(id);
        return " Successfully deleted!";
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepository.assignInstructorToCourse(instructorId, courseId);
    }
}
