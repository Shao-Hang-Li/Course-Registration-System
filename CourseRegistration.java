package CourseRegistrationSystem;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * registration System by Qi He, Shao Hang Li, John Nicholas
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
     * Arraylist for students
     */
    private final ArrayList<Student> students = new ArrayList<>();
    /**
     * Scanner for inputs
     */
    private final Scanner scanner;          // Scanner instance for user input

    /**
     * Initialization for the scanner
     */
    public CourseRegistration() {
        scanner = new Scanner(System.in);   // Initialize the Scanner
    }

    /**
     * The main method to start the entire program
     * @param args arguments for main
     * 
     */
    public static void main(String[] args) {                        // Main method
        CourseRegistration application = new CourseRegistration();  // Create a new instance for CourseRegistration
        application.start();                                        // Start the program
    }

    /**
     * Method for allowing registration to start
     */
    public void start() {
        int options;                            //Declare variable to store user input option
        try {
            do {
                displayMenu();                  //Display the menu to show all the options
                options = scanner.nextInt();    //The scanner takes the next integer
                scanner.nextLine();            
                System.out.printf("\n"); //New line (to have space, so not everything is stick together when you print the options)

                // Switch case to determine which option the user has chosen
                switch (options) {              //User can choose different options to do different things
                    case 1: addCourse();        //add new course 
                    break;                      //leave the loop, so it doesn't continue to the other one
                    case 2: displayCourses();   //display courses
                    break;
                    case 3: addStudent();       //add a new student
                    break;
                    case 4: displayStudents();  //display all the students
                    break;
                    case 5: registerStudentForCourse(); //register student to a course method (require ID and course ID)
                    break;
                    case 6: checkCourseEnrolled();      //display course enrolled 
                    break;
                    case 7: System.out.println("Bye, and have a wonderful day!");  //Exit
                    break;
                    default: System.out.println("Oh no! Try again!");              //Invalid input to trigger this line
                }

            } while (options != 7);             // 7 cases 
        } 
        catch (Exception e) {                   //handles if user enter invalid input ex.String 
            System.out.printf("Exception: %s %n", e);
        }
        
        scanner.close();                        // Close the scanner when done
    }

    /**
     * Void for displaying the menu
     */
    public void displayMenu() {                                         // Display Menu for all the options
        System.out.println("\nCourse Registration System");           // Add a new line
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
    public void addCourse() {                           // Adding a new course
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();         //Input course code and store as a String
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();         //Input course name and store as a String
        System.out.print("Enter professor name: ");
        String professor = scanner.nextLine();          //Input professor name and store as a String
        try {                                           //Exception handling to prevent program break 
            if (findCourseByCode(courseCode) != null) { //Check if course already exist 
                throw new InvalidUserInput("Course already exist. Registration failed.");
            }
            courses.add(new Course(courseCode, courseName, professor)); //create course object and add to array list
            System.out.println("Course added: courseCode='" + courseCode + "', courseName='" + courseName + "', professor='" + professor + "'");
            
        } catch (Exception e) {                         //catch exception and display error message
            System.out.printf("Exception: %s %n", e);
        }
    }

    /**
     * void for displaying courses
     */
    public void displayCourses() {                                                  // Display course method
        System.out.println("\nCourses:");                                         // Add a new line to space out
        for (Course course : courses) {                                             // for each loop that goes over each Course object in the courses arraylist
            System.out.println(course.displayCourseInfo());                         // display course info (return a String that we made in displayCourseInfo() in course.java)
            System.out.println("-------------------------------------------");    // separation line
        }
    }

    /**
     * void for adding students
     */
    public void addStudent() {                          //Add student method
        System.out.print("Enter student ID: ");       //Prompt to enter the student ID
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

                if (findStudentByID(studentID) != null) {               //check if student already enrolled
                    throw new InvalidUserInput("Student already exist. Registration failed.");
                }
                students.add(new Student(studentName, studentID));      //create student object and add to array list
                System.out.println("Student added: studentID=" + studentID + ", studentName='" + studentName + "'");
            }
        } catch (Exception e) {                                         //catch and handles the exception
            System.out.printf("Exception: %s %n", e);
        }
    }

    /**
     * void for displaying students
     */
    public void displayStudents() {                          //Display student method
        System.out.println("\nStudents:");                 //Add new line to space out
        for (Student student : students) {                   //for each loops that goes through all the student in the students list
            System.out.println(student.displayStudentInfo());//display student objects
            System.out.println("-------------------------------------------");
        }
    }

    /**
     * void for registering students
     */
    public void registerStudentForCourse() {            //Register student for course method
        int studentID;                                  //Variable and type declarations
        Course course;                                  //Variable to hold the course object that goes with the course code
        Student student;                                //Variable to hold the student object that goes with the course ID

        System.out.print("Enter your course code to register: ");
        String courseCode = scanner.nextLine();         //Input the courseCode and store as a String
        System.out.print("Enter your student ID to register: ");
        //try get to prevent invalid input, Invalid user input exception is not thrown here->simply student not found.
        try {
            studentID = scanner.nextInt();

            course = findCourseByCode(courseCode);
            student = findStudentByID(studentID);
    
            // This is to check if you already registered or is missing informations by using conditional statement (AND logical operators, both sides must be TRUE)
            // https://www.geeksforgeeks.org/interesting-facts-about-null-in-java/ using null
            if (course != null && student != null) {        //check if the courseID and the studentID exist and are registered (have to input both in the options)
                if (course.registerStudent(studentID)) {    //check if registration is completed
                    System.out.printf("You have registered successfully for ", courseCode);  //Print the comment with the course code
                } else {
                    System.out.println("You are already registered for this course.");        //Print the comment that if he is already registered

                }
            } else {
                System.out.println("Course or Student not found.");                              //Print not found if it doesn't exist
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

