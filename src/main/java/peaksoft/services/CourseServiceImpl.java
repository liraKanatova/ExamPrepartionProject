package peaksoft.services;

import peaksoft.model.Course;
import peaksoft.repositories.CourseRepository;
import peaksoft.repositories.CourseRepositoryImpl;

import java.util.List;

public class CourseServiceImpl implements CourseService{
    CourseRepository courseRepository = new CourseRepositoryImpl();
    @Override
    public String saveCourse(Course course) {
         courseRepository.saveCourse(course);
         return  "successfully saved!";
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public List<Course> getAllCoursecraeteAt(String ascOrDesc) {
        return courseRepository.getAllCoursecraeteAt(ascOrDesc);
    }

    @Override
    public Course updateCourse(Long id, Course newCourse) {
        return courseRepository.updateCourse(id, newCourse);
    }

    @Override
    public String deleteCourseById(Long id) {
        courseRepository.deleteCourseById(id);
        return " Successfully deleted!";
    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepository.getCourseByName(name);
    }
}
