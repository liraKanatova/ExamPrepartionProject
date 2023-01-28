package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.model.Course;
import peaksoft.model.Instructor;
import peaksoft.model.Lesson;
import peaksoft.model.Task;
import peaksoft.services.*;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HibernateConfig.getEntityManager();

        CourseService courseService = new CourseServiceImpl();
        InstructorService instructorService = new InstructorServiceImpl();
        LessonService lessonService = new LessonServiceImpl();
        TaskService taskService = new TaskServiceImpl();
        while (true) {
            System.out.println("""
                    ~~~~~Course Commands~~~~
                    1 Saved Course!
                    2 Get Course By Id!
                    3 Get All Course CraeteAt!
                    4 Update Course!
                    5 Delete Course By Id!
                    6 Get Course By Name!
                    ~~~Instructor Commands~~~
                    7 Save Instructor!
                    8 Update Instructor!
                    9 Get Instructor By Id!
                    10 Get Instructors By Course Id!
                    11 Delete Instructor By Id!
                    12 Assign Instructor To Course!
                    ~~~~~~~Lesson Commands~~~~~~
                    13 Save Lesson!
                    14 Update Lesson!
                    15 Get Lesson By Id!
                    16 Get Lessons By Course Id!
                    ~~~~~~~Task Commands~~~~~~~
                    17  Save Task!
                    18 Update Task!
                    19 Get All Task By Lesson Id!
                    20 Delete Task By Id!
                    """);
            System.out.println("Enter by command :");
            int num = new Scanner(System.in).nextInt();
            switch (num) {
                case 1 -> courseService.saveCourse(new Course("Js", 7, LocalDate.of(2023, 1, 15), "link", "Frontend"));
                case 2 -> System.out.println(courseService.getCourseById(1L));
                case 3 -> {
                    System.out.print("Write the asc or desc: ");
                    String ascOrDesc = new Scanner(System.in).nextLine();
                    System.out.println(courseService.getAllCoursecraeteAt(ascOrDesc));
                }
                case 4 -> {
                    System.out.print("Write the id and that which you want to change: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.print("Write the courseName: ");
                    String courseName = new Scanner(System.in).next();
                    System.out.print("Write the duration: ");
                    int duration = new Scanner(System.in).nextInt();
                    System.out.print("Write the createAt: ");
                    Scanner scanner = new Scanner(System.in);
                    LocalDate createAt = LocalDate.of(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                    System.out.print("Write the imageLink: ");
                    String imageLink = new Scanner(System.in).next();
                    System.out.print("Write the description: ");
                    String description = new Scanner(System.in).next();
                    System.out.println(courseService.updateCourse(id, new Course(courseName, duration, createAt, imageLink, description)));
                }
                case 5 -> {
                    System.out.print("Write the id: ");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(courseService.deleteCourseById(courseId));
                }
                case 6 -> {
                    System.out.print("write the name: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.println(courseService.getCourseByName(name));
                }
                case 7 -> instructorService.saveInstructor(new Instructor("Aizhan", "Nutmatova", "aizhan@gmail.com", "+996888777666"));
                case 8 -> {
                    System.out.print("Write the id and that which you want to change: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.print("Write the firstName: ");
                    String firstName = new Scanner(System.in).next();
                    System.out.print("Write the lastName: ");
                    String lastName = new Scanner(System.in).next();
                    System.out.print("Write the email: ");
                    String email = new Scanner(System.in).next();
                    System.out.print("Write the phoneNumber: ");
                    String phoneNumber = new Scanner(System.in).nextLine();
                    instructorService.updateInstructor(id, new Instructor(firstName, lastName, email, phoneNumber));
                }
                case 9 -> {
                    System.out.print("Write the instructor id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(instructorService.getInstructorById(id));
                }
                case 10 -> {
                    System.out.print("Write the course id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(instructorService.getInstructorsByCourseId(id));
                }
                case 11 -> {
                    System.out.print("Write the instructor id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(instructorService.deleteInstructorById(id));
                }
                case 12 -> instructorService.assignInstructorToCourse(1L, 2L);
                case 13 -> System.out.println(lessonService.saveLesson(1L, new Lesson("JDBC", "adfsa")));
                case 14 -> {
                    System.out.print("Write the id and that which you want to change: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.print("write the name: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.print("Write the videoLink: ");
                    String videoLink = new Scanner(System.in).nextLine();
                    System.out.print("Write the courseId: ");
                    Long courseId = new Scanner(System.in).nextLong();
                    System.out.println(lessonService.updateLesson(id, new Lesson(name, videoLink)));
                }
                case 15 -> {
                    System.out.print("Write the lesson id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(lessonService.getLessonById(id));
                }
                case 16 -> {
                    System.out.print("Write the Course id: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.println(lessonService.getLessonsByCourseId(id));
                }
                case 17 -> taskService.saveTask(1L, new Task("Hibernate", "11:00", "task jdbs"));
                case 18 -> {
                    System.out.print("Write the id and that which you want to change: ");
                    Long id = new Scanner(System.in).nextLong();
                    System.out.print("write the name: ");
                    String name = new Scanner(System.in).nextLine();
                    System.out.print("Write the deadline: ");
                    String deadline = new Scanner(System.in).nextLine();
                    System.out.print("Write the task: ");
                    String task = new Scanner(System.in).nextLine();
                    System.out.println(taskService.updateTask(id, new Task(name, deadline, task)));
                }
                case 19 -> {
                    System.out.print("Write the lesson id: ");
                    Long lessonId = new Scanner(System.in).nextLong();
                    System.out.println(taskService.getAllTaskByLessonId(lessonId));
                }
            }


        }
    }
}
