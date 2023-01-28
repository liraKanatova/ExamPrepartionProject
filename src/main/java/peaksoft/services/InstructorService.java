package peaksoft.services;

import peaksoft.model.Instructor;

import java.util.List;

public interface InstructorService {
    String saveInstructor(Instructor instructor);
    Instructor updateInstructor(Long id , Instructor newInstructor);
    Instructor getInstructorById( Long id);
    List<Instructor> getInstructorsByCourseId(Long id);
    String deleteInstructorById(Long id);
    void assignInstructorToCourse(Long instructorId,Long courseId);

}
