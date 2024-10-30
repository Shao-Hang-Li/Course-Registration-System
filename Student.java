package CourseRegistrationSystem;
/** 
 * The Student class reprents the student names and IDs with the ability to set new names and assign them new ids.
 * 
 * <p>This class keeps track of all the students that have or will register to the school. It is recorded with their names and their ids.
 * 
 * 
 * @see Course
 * @see CourseRegistration
 * 
 */ 
public class Student {
    //Variables for student ID and Student name
    /**
     * The student's ID
     */
    private final int studentID;                // Student ID number (Unique)
    /**
     * The student's name
     */
    private final String studentName;      // Student name

    /**
     * Allows the student name and id to be set.
     * @param studentName Sets student name
     * @param studentID Sets student ID
     */
    public Student(String studentName, int studentID) {
        this.studentName = studentName;   // Set the student name
        this.studentID = studentID;                 // Set the student ID
    }

    /**
     * getter for student name
     * @return shows student name
     */
    public String getStudentName() {
        return studentName;

    }

    /**
     * getter for student id
     * @return Shows student ID
     */
    public int getStudentID() {
        return studentID;
    }


    /**
     * Display method for student id and name
     * @return display for student id
     */
    public String displayStudentInfo() {
        return "Student ID: " + studentID + ", Name: " + studentName;
    }
}

