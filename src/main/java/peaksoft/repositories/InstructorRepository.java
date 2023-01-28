package peaksoft.repositories;

import peaksoft.model.Course;
import peaksoft.model.Instructor;

import java.util.List;

public interface InstructorRepository {
    String saveInstructor(Instructor instructor);
    Instructor updateInstructor(Long id , Instructor newInstructor);
    Instructor getInstructorById( Long id);
    List<Instructor> getInstructorsByCourseId(Long id);
   String deleteInstructorById(Long id);
  void assignInstructorToCourse(Long instructorId,Long courseId);

}
