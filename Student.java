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
     * @param studentName
     * @param studentID
     */
    public Student(String studentName, int studentID) {
        this.studentName = studentName;   // Set the student name
        this.studentID = studentID;                 // Set the student ID
    }

    /**
     * shows Student Name
     * @return
     */
    public String getStudentName() {
        return studentName;

    }

    /**
     * Shows student ID
     * @return
     */
    public int getStudentID() {
        return studentID;
    }


    /**
     * Displays full infor for student ID and student Name
     * @return
     */
    public String displayStudentInfo() {
        return "Student ID: " + studentID + ", Name: " + studentName;
    }
}

