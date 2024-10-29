package CourseRegistrationSystem;

public class Student {
    // Variables and types declaration
    private final int studentID;                // Student ID number (Unique)
    private final String studentFirstName;      // Student first name
    private final String studentLastName;       // Student last name

    // Constructor for Student (with their respective parameters)
    public Student(String studentFirstName, String studentLastName, int studentID) {
        this.studentFirstName = studentFirstName;   // Set the student first name
        this.studentLastName = studentLastName;     // Set the student last name
        this.studentID = studentID;                 // Set the student ID
    }

    // Getter for the student first name
    public String getStudentFirstName() {
        return studentFirstName;
    }

    // Getter for the student last name
    public String getStudentLastName() {
        return studentLastName;
    }

    // Getter for the student ID
    public int getStudentID() {
        return studentID;
    }

    // Display the student information by returning a string (studentID, studentFirstName, studentLastName)
    public String displayStudentInfo() {
        return "Student ID: " + studentID + ", Name: " + studentFirstName + " " + studentLastName;
    }
}
