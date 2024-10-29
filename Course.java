package CourseRegistrationSystem;

import java.util.ArrayList;

public class Course {
    // Variables and types declaration for Course
    private final String courseCode;                         // Unique code for the course
    private final String courseName;                         // Name of the course
    private final String professor;                          // Name of the professor
    private final ArrayList<Integer> enrolledStudents;       // List of student IDs

    // Constructor for initializing Course object
    public Course(String courseCode, String courseName, String professor) {
        this.courseCode = courseCode;                        // Set course code
        this.courseName = courseName;                        // Set course name
        this.professor = professor;                          // Set professor name
        this.enrolledStudents = new ArrayList<>();           // Initialize the list of enrolled students
    }

    // Getters for course properties
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getProfessor() {
        return professor;
    }

    public ArrayList<Integer> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Register student in the course
    public boolean registerStudent(int studentID) {
        if (!enrolledStudents.contains(studentID)) {         // Avoid duplicate student IDs
            enrolledStudents.add(studentID);
            return true;
        }
        return false;                                          // Student already enrolled
    }

    // Display the course information
    public String displayCourseInfo() {
        return courseCode + ", " + courseName + ", " + professor;
    }
}
