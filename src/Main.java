import model.Course;
import model.Student;
import service.RegistrationService;

public class Main {
    public static void main(String[] args) {
        RegistrationService service = new RegistrationService();

        Student s1 = new Student("202601", "Roaa");
        Student s2 = new Student("202602", "Layan");
        service.addStudent(s1);
        service.addStudent(s2);

        Course c1 = new Course("SE301", "Software Refactoring", 30);
        Course c2 = new Course("SE302", "Formal Specifications", 25);
        service.addCourse(c1);
        service.addCourse(c2);

        service.registerStudentToCourse("202601", "SE301");
        service.registerStudentToCourse("202601", "SE302");
        service.registerStudentToCourse("202602", "SE301");

        service.printStudentCourses("202601");
        service.printStudentCourses("202602");
    }
}
