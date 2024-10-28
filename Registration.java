package CourseRegistrationSystem;
/**
 * registration System by Qi He, Shaohang Li, John Nicholas
 * 
 * This class performs registration management.
 * It contains the following methods:
 * 1. enroll new student
 * 2. get spots left
 * 3. register a new course (to be changed into arraylist)
 * 4. get registration detail for all courses (to be changed to read from arraylist)
 * 5. update the course arraylist (find corresponding array and update it)
 * 6. add new student to student arraylist (add to arraylist)
 */
//import libraries to read from file and write into file
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Registration {
    private int courseNumber, maxSeat, studentEnrolled, spotsAvailable;
    private String courseName, professor;

    //This method take a Student class object and a course class object
    //and updates the course info if registration suceeded
    public void enrollNewStudent(Student aStudent, Course aCourse){
        //initialize variables for future use in the method
        studentEnrolled = aCourse.getCourseEnrolled();
        maxSeat = aCourse.getMaxNumberStudents();
        spotsAvailable = maxSeat - studentEnrolled;

        //case if there are enough spots
        if (spotsAvailable > 0) {
            System.out.printf("Your Registration has been complete and recorded for %s!%n", aCourse.getCourseName());
            //update student Enrolled
            studentEnrolled += 1;
            aCourse.setCourseEnrolled(studentEnrolled);


            //update registered courses to student arraylist



        }

        //case if there are not enough spots
        else{
            System.out.printf("There are not enough seats available in course %s! Registration Failed!%n", aCourse.getCourseName());
        }
    }

    //The method take a Course class variable
    //and returns number of seats available
    public int getSeatsAvailable(Course aCourse){
        //initialize variables for future use in the method
        studentEnrolled = aCourse.getCourseEnrolled();
        maxSeat = aCourse.getMaxNumberStudents();
        spotsAvailable = maxSeat - studentEnrolled;

        System.out.printf("The number of Seats available in %s is %d. %n",aCourse.getCourseName(), spotsAvailable);
        return spotsAvailable;//to be used if necessary

    }

    //this method takes a Course class variable and write it into Registered Courses File
    public void registerNewCourse(Course aCourse) throws FileNotFoundException{
        PrintWriter outFile; // instance of PrintWriter class
        outFile = new PrintWriter("RegisteredCourses.txt");
        //writes the new course info into the file
        outFile.printf("%s,%s,%s,%s,%s,", aCourse.getCourseCode(), aCourse.getCourseName(), aCourse.getProfessor(), aCourse.getMaxNumberStudents(), aCourse.getCourseEnrolled());
        outFile.close();
    }

    //this method takes no input and prints all registered courses by reading from a file
    public void getAllCourses() throws FileNotFoundException{
        // declare reference variables (object)
        Scanner inFile; // instance of the FileReader class

        // initialize the inFille scanner object
        inFile = new Scanner(new FileReader("RegisteredCourses.txt"));
        //seperated by comma so a full name will not be read as two elements
        inFile.useDelimiter(",");

        System.out.println("***************************************************");
        while (inFile.hasNext()){
            //get data from the file
            courseNumber = Integer.valueOf(inFile.next());
            courseName = inFile.next();
            professor = inFile.next();
            maxSeat = Integer.valueOf(inFile.next());
            studentEnrolled = Integer.valueOf(inFile.next());
            //print them out
            System.out.printf("Course Number: %d, Course Name: %s, Professor: %s, Max Amount of Students: %d, Students Enrolled: %d %n", courseNumber, courseName, professor, maxSeat, studentEnrolled);
        }
        System.out.println("***************************************************");
        inFile.close();
    }
    
}