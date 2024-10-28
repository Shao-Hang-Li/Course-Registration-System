package CourseRegistrationSystem;

import java.util.ArrayList;

public class Course {
    // Variables and types declaration for Course
    private final String courseCode;                        // Unique code for the course (Ex: IFT1015)
    private final String courseName;                        // Name of the course
    private final String professor;                         // Name of the professor for the specific course
    private final ArrayList<Integer> enrolledStudents;      // List of student IDs

    // Constructor for initializing Course object (Ex: IFT1015, Introduction to Programming, Alena Tsikhanovich)
    public Course(String courseCode, String courseName, String professor) {
        this.courseCode = courseCode;                       // Set course code
        this.courseName = courseName;                       // Set course name
        this.professor = professor;                         // Set professor name
        this.enrolledStudents = new ArrayList<>();          // Arraylist for enrolled students (empty list)
    }

    // Getter for courseCode
    public String getCourseCode() {
        return courseCode;
    }

    // Getter for courseName
    public String getCourseName() {
        return courseName;
    }

    // Getter for professor name
    public String getProfessor() {
        return professor;
    }

    // Getter for the list of enrolled students
    public ArrayList<Integer> getEnrolledStudents() {
        return enrolledStudents;
    }

    // Register student in the course
    public boolean registerStudent(int studentID) {
        if (!enrolledStudents.contains(studentID)) {                // This is to avoid having multiple same student IDs (since ID is unique)
            enrolledStudents.add(studentID);
            return true;
        }
        return false;                                               // Student already enrolled
    }

    // Remove student from course (based on their ID)
    public boolean removeStudent(int studentID) {
        return enrolledStudents.remove(Integer.valueOf(studentID)); // Remove if exists
    }

    //Return the correct way for the String
    @Override
    public String toString() {
        return "Course Code: " + courseCode + ", Name: " + courseName + ", Professor: " + professor;
    }
}
