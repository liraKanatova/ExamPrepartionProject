package peaksoft.repositories;

import peaksoft.model.Course;

import java.util.List;

public interface CourseRepository {
    String saveCourse(Course course);
    Course getCourseById(Long courseId);
    List<Course>  getAllCoursecraeteAt(String ascOrDesc);
    Course updateCourse(Long id ,Course newCourse);
    String deleteCourseById(Long id);
    Course getCourseByName(String name);



}
