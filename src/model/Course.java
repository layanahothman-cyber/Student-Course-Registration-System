package model;

public class Course {
    private String courseCode;
    private String title;
    private int capacity;

    public Course(String courseCode, String title, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.capacity = capacity;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return courseCode + " - " + title + " (Capacity: " + capacity + ")";
    }
}
