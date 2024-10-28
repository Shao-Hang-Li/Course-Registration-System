package CourseRegistrationSystem;

public class Student {
    // Variables and types declaration
    private final int studentID;                // Student ID number (Unique)
    private final String studentName;      // Student name

    // Constructor for Student (with their respective parameters)
    public Student(String studentFirstName, String studentLastName, int studentID) {
        this.studentName = studentName;   // Set the student name
        this.studentID = studentID;                 // Set the student ID
    }

    // Getter for the student first name
    public String getStudentName() {
        return studentName;

    }

    // Getter for the student last name
    public String getStudentLastName() {
        return studentLastName;
    }

    // Getter for the student ID
    public int getStudentID() {
        return studentID;
    }

    //Return the correct way for the String (override toString() from the Object class)
    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Name: " + studentName;
    }
}