package service;

import model.Course;
import model.Student;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationService {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private Map<String, List<Course>> registrations = new HashMap<>();

    public void addStudent(Student student) {
        students.add(student);
        registrations.putIfAbsent(student.getStudentId(), new ArrayList<>());
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean registerStudentToCourse(String studentId, String courseCode) {
        Student foundStudent = null;
        for (Student s : students) {
            if (s.getStudentId().equals(studentId)) {
                foundStudent = s;
                break;
            }
        }

        Course foundCourse = null;
        for (Course c : courses) {
            if (c.getCourseCode().equals(courseCode)) {
                foundCourse = c;
                break;
            }
        }

        if (foundStudent == null || foundCourse == null) {
            return false;
        }

        List<Course> studentCourses = registrations.get(studentId);
        if (!studentCourses.contains(foundCourse)) {
            studentCourses.add(foundCourse);
            return true;
        }
        return false;
    }

    public void printStudentCourses(String studentId) {
        List<Course> studentCourses = registrations.get(studentId);
        System.out.println("Registered courses for student " + studentId + ":");
        if (studentCourses == null || studentCourses.isEmpty()) {
            System.out.println("  No courses registered.");
            return;
        }
        for (Course c : studentCourses) {
            System.out.println("  - " + c);
        }
    }
}
