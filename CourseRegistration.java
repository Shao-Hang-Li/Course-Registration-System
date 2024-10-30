package CourseRegistrationSystem;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * registration System by Qi He, Shaohang Li, John Nicholas
 * 
 * This class performs registration management.
 * It contains the following methods:
 * 1. add new course
 * 2. display all course objects
 * 3. add new student
 * 4. display all student objects
 * 5. register student to a course
 * 6. check courses enrolled of a student by student ID
 * 
 * @see Student
 * @see Course
 */


public class CourseRegistration {
    /**
     * Arraylist for courses
     */
    private final ArrayList<Course> courses = new ArrayList<>();
    /**
     * Arralist for students
     */
    private final ArrayList<Student> students = new ArrayList<>();
    /**
     * Scanner for inputs
     */
    private final Scanner scanner;  // Scanner instance for user input

    /**
     * Initilization for the scanner
     */
    public CourseRegistration() {
        scanner = new Scanner(System.in); // Initialize the Scanner
    }

    /**
     * The main method to run the entire program
     * @param args arguments for main
     * 
     */
    public static void main(String[] args) {
        CourseRegistration application = new CourseRegistration();
        application.run();
    }

    /**
     * Method for allowing registration to run
     */
    public void run() {
        int option;                         //declare variable to store user input option
        try {
            do {
                displayMenu();                  //display menu method to show menu options
                option = scanner.nextInt();     //take next integer
                scanner.nextLine();            
                System.out.println();           //New line
                switch (option) {               //different functions according to user option
                    case 1: addCourse();        //add new course method
                    break;                      //leave the loop
                    case 2: displayCourses();   //display new course method
                    break;
                    case 3: addStudent();       //add new student method
                    break;
                    case 4: displayStudents();  //display all students method
                    break;
                    case 5: registerStudentForCourse(); //register student to a course method
                    break;
                    case 6: checkCourseEnrolled();      //display course enrolled method
                    break;
                    case 7: System.out.println("Exiting the system.");  //leave the loop option
                    break;
                    default: System.out.println("Invalid option. Try again.");//invalid int input will trigger this
                }
            } while (option != 7);
        } catch (Exception e) {                 //handles if user enter invalid input ex.String 
            System.out.printf("Exception: %s %n", e);
        }
        
        scanner.close();                        // Close the scanner when done
    }

    /**
     * Void for displaying the menu
     */
    public void displayMenu() {
        System.out.println("\nCourse Registration System");
        System.out.println("1. Add Course");
        System.out.println("2. Display Courses");
        System.out.println("3. Add Student");
        System.out.println("4. Display Students");
        System.out.println("5. Register Student for the Course");
        System.out.println("6. View courses enrolled");
        System.out.println("7. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Void for adding courses
     */
    public void addCourse() {
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();         //take user input and store as a String
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();         //take course name and store as a String
        System.out.print("Enter professor name: ");
        String professor = scanner.nextLine();          //take professor name and store as a String
        try {                                           //Exception handling to prevent program break
            if (findCourseByCode(courseCode) != null) { //Check if course already exist 
                throw new InvalidUserInput("Course already exist. Registration failed.");
            }
            courses.add(new Course(courseCode, courseName, professor)); //creat course object and add to array list
            System.out.println("Course added: courseCode='" + courseCode + "', courseName='" + courseName + "', professor='" + professor + "'");
            
        } catch (Exception e) {                         //catch exception and display error message
            System.out.printf("Exception: %s %n", e);
        }
        
    }

    /**
     * void for displaying courses
     */
    public void displayCourses() {
        System.out.println("\nCourses:");
        for (Course course : courses) {                 //access all cours object from array list
            System.out.println(course.displayCourseInfo()); //display course info
            System.out.println("-------------------------------------------");
        }
    }

    /**
     * void for adding students
     */
    public void addStudent() {
        System.out.print("Enter student ID: ");
        //try method to prevent program break
        try {
            int studentID = scanner.nextInt();          //take user input and store as an integer
            if (studentID <= 0){                        //if input is negative, throw exception
                throw new InvalidUserInput("Please enter a valid student number.");
            }
            else{
                scanner.nextLine();                                     // Scan New line
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine();                //take student name and store as a String

                if (findStudentByID(studentID) != null) {              //check if student already enrolled
                    throw new InvalidUserInput("Student already exist. Registration failed.");
                }
                students.add(new Student(studentName, studentID));      //create student object and add to array list
                System.out.println("Student added: studentID=" + studentID + ", studentName='" + studentName + "'");
            }
        } catch (Exception e) {                         //catch and handels the exception
            System.out.printf("Exception: %s %n", e);
        }
    }

    /**
     * void for displaying students
     */
    public void displayStudents() {
        System.out.println("\nStudents:");            
        for (Student student : students) {              //iterate through array list to access all student object
            System.out.println(student.displayStudentInfo());//display student objects
            System.out.println("-------------------------------------------");
        }
    }

    /**
     * void for registering students
     */
    public void registerStudentForCourse() {
        System.out.print("Enter course code to register: ");
        String courseCode = scanner.nextLine();         //take course code and store in String
        System.out.print("Enter student ID to register: ");
        //try get to prevent invalid input, Invalid user input exception is not thrown here->simply student not found.
        try {
            int studentID = scanner.nextInt();

            Course course = findCourseByCode(courseCode);
            Student student = findStudentByID(studentID);
    
            // This is to check if you already registered or is missing informations
            if (course != null && student != null) {
                if (course.registerStudent(studentID)) {    //check if registration is completed
                    System.out.println("Student registered successfully for " + courseCode);
                } else {
                    System.out.println("Student is already registered for this course.");
                }
            } else {
                System.out.println("Course or Student not found.");
            }
    
        } catch (Exception e) {                             //prepared for inputing anything else than int
            System.out.printf("Exception: %s %n", e);
        }

    }

    /**
     * void for checking course enrollment
     */
    private void checkCourseEnrolled(){
        System.out.print("Enter student ID to search: ");
        try {                                               //use try catch to avoid program break with invalid input
            int studentID = scanner.nextInt();              //take user input and store as an int
            if (findStudentByID(studentID) == null) {       //if student is not found, throw exception
                throw new InvalidUserInput("Invalid student ID.");
            }
            else{
                System.out.printf("Student %s is enrolled in the following courses (empty if none): %n", studentID);
                for (Course course : courses) {                                  //Iterate through course arraylist to check each course object
                    if(course.ifStudentEnrolled(studentID)){                     //If Student is enrolled, print course number
                        System.out.printf("%s%n", course.getCourseName());//displays course name
                    }
                }
            }
        } catch (Exception e) {
            System.out.printf("Exception: %s %n", e);
        }

    }


    /**
     * void for finding course codes
     * @param courseCode used to find course code
     * @return course code selected
     */
    private Course findCourseByCode(String courseCode) {
        for (Course course : courses) {                     //Iterate through the course array list to access all course object
            if (course.getCourseCode().equals(courseCode)) {//If input equals a course code, return the course object
                return course;
            }
        }
        return null;
    }

    /**
     * void for finding student ID
     * @param studentID search fo student id
     * @return student id selected
     */
    private Student findStudentByID(int studentID) {
        for (Student student : students) {              //Iterate through the student array list to access all student object
            if (student.getStudentID() == studentID) {  //If input equals a student code, return the student object
                return student;
            }
        }
        return null;
    }
}

