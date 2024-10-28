/* This class preforms the registration of new students
 * It contains the following methods:
 * 1. Register new student first and last name
 * 2. Assign number to new student
 * 3. Allow looking up students
 */
import java.util.Scanner;
class StudentRegistration {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student[] student;
        double idSearch;
        student = new Student[3];
        //first student
        student[0] = new Student(1, "Johnny Test");
        //second student
        student[1] = new Student(2, "Mary Joseph");
        //third student
        student[2] = new Student(3, "Seymour Skinner");

        System.out.println("Please enter the student id you would like to see");
        idSearch = input.nextDouble();
        if(idSearch == 1) {
            student[0].display();
        }
        else
        if(idSearch == 2) {
            student[1].display();
        }
        else
        if(idSearch == 3) {
            student[2].display();
        }
        else {
            System.out.println("Sorry, no student of this number exists");
        }
        input.close();    
    }
}

class Student {
    public int studentID;
    public String studentName;

    Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public void display() {
        System.out.printf("Student number is: " + studentID + "%nThe student's name is: " + studentName);
        System.out.println();
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentName(String aStudentName) {
        this.studentName = aStudentName;
    }

    public void setStudentID(int aStudentID) {
        this.studentID = aStudentID;
    }
}