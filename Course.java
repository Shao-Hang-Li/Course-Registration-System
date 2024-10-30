package CourseRegistrationSystem;

import java.util.ArrayList;

/** 
 * The Course class represents the courses available at the school, with operations such as the course number, the course name, and the professer in charge of the course.
 * 
 * <p>This class keeps track of all of the courses for students to enroll in. Each student is recorded based on which class they choose.
 * 
 * @author Qi He, Shao Hang Li, John Nicholas
 * @version 1.0
 * @since 2024-10-29
 * @see Student
 * @see CourseRegistration
 * 
 */ 
public class Course {
    // Variables and types declaration for Course
    /**
     * Course code of classes
     */
    private final String courseCode;                         // Unique code for the course
    /**
     * Course name of classes
     */
    private final String courseName;                         // Name of the course
    /**
     * Professer of classes
     */
    private final String professor;                          // Name of the professor
    /**
     * Array for enrolled students
     */
    private final ArrayList<Integer> enrolledStudents;       // List of student IDs
    /**
     * This is the setter for the course code, course name, professor, and enrolled students
     * @param courseCode initialize course code
     * @param courseName initialize course name
     * @param professor initialize professor
     */
    // Constructor for initializing Course object
    public Course(String courseCode, String courseName, String professor) {
        this.courseCode = courseCode;                        // Set course code
        this.courseName = courseName;                        // Set course name
        this.professor = professor;                          // Set professor name
        this.enrolledStudents = new ArrayList<>();           // Initialize the list of enrolled students
    }

    /**
     * Shows course code
     * @return shows course code
     */
    public String getCourseCode() {                         // Getter for Course code
        return courseCode;
    }
    /**
     * Shows course name
     * @return course name
     */
    public String getCourseName() {                         // Getter for Course name
        return courseName;
    }
    /**
     * Shows professor
     * @return professor
     */
    public String getProfessor() {                          // Getter for Professor
        return professor;
    }
    /**
     * Shows enrolled students
     * @return enrolled students
     */
    public ArrayList<Integer> getEnrolledStudents() {       // Getter for enrolled students
        return enrolledStudents;
    }
    /**
     * This method allows a student to be registered in a course based on their student ID
     * @param studentID allows students to be enrolled in class
     * @return if students are already registered
     */
    // Register student in the course
    public boolean registerStudent(int studentID) {          // Logical method for registering students
        if (!enrolledStudents.contains(studentID)) {         // Avoid duplicate student IDs
            enrolledStudents.add(studentID);                 // If it doesn't contain the studentID, it can add the student ID
            return true;
        }
        return false;                                        // Student already enrolled
    }

    /**
     * This method determines if a student is already enrolled in a class.
     * @param studentID sees if student is already in class
     * @return if student is already in class or not
     */
    public boolean ifStudentEnrolled(int studentID){
        if (enrolledStudents.contains(studentID)) {          // Check if student is already in the Course
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method displays the full code, name and professor of the course
     * @return display for the course code, name, and professor
     */
    public String displayCourseInfo() {                     // Display course information
        return "Course Code: " + courseCode + "\n" + "Course Name: " + courseName + "\n" + "Professor: " + professor;
    }
}
