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
        int option;
        do {
            displayMenu();
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (option) {
                case 1: addCourse(); 
                break;
                case 2: displayCourses(); 
                break;
                case 3: addStudent(); 
                break;
                case 4: displayStudents(); 
                break;
                case 5: registerStudentForCourse(); 
                break;
                case 6: checkCourseEnrolled();
                break;
                case 7: System.out.println("Exiting the system."); 
                break;
                default: System.out.println("Invalid option. Try again.");
            }
        } while (option != 7);
        scanner.close(); // Close the scanner when done
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
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter professor name: ");
        String professor = scanner.nextLine();
        try {
            if (findCourseByCode(courseCode) != null) {
                throw new InvalidUserInput("Course already exist. Registration failed.");
            }
            courses.add(new Course(courseCode, courseName, professor));
            System.out.println("Course added: courseCode='" + courseCode + "', courseName='" + courseName + "', professor='" + professor + "'");
            
        } catch (Exception e) {
            System.out.printf("Exception: %s %n", e);
        }
        
    }

    /**
     * void for displaying courses
     */
    public void displayCourses() {
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println(course.displayCourseInfo());
        }
    }

    /**
     * void for adding students
     */
    public void addStudent() {
        System.out.print("Enter student ID: ");
        //try method to prevent break
        try {
            int studentID = scanner.nextInt();
            if (studentID <= 0){ 
                throw new InvalidUserInput("Please enter a valid student number.");
            }
            else{
                scanner.nextLine();                                     // Scan New line
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine();

                if (findStudentByID(studentID) != null) {              //check for repetition
                    throw new InvalidUserInput("Student already exist. Registration failed.");
                }
                students.add(new Student(studentName, studentID));
                System.out.println("Student added: studentID=" + studentID + ", studentName='" + studentName + "'");
            }
        } catch (Exception e) {
            System.out.printf("Exception: %s %n", e);
        }
    }

    /**
     * void for displaying students
     */
    public void displayStudents() {
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.displayStudentInfo());
        }
    }

    /**
     * void for registering students
     */
    public void registerStudentForCourse() {
        System.out.print("Enter course code to register: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter student ID to register: ");
        //try get to prevent invalid input, Invalid user input exception is not thrown here->simply student not found.
        try {
            int studentID = scanner.nextInt();

            Course course = findCourseByCode(courseCode);
            Student student = findStudentByID(studentID);
    
            // This is to check if you already registered or is missing informations
            if (course != null && student != null) {
                if (course.registerStudent(studentID)) {
                    System.out.println("Student registered successfully for " + courseCode);
                } else {
                    System.out.println("Student is already registered for this course.");
                }
            } else {
                System.out.println("Course or Student not found.");
            }
    
        } catch (Exception e) {                                               //prepared for inputing anything else than int
            System.out.printf("Exception: %s %n", e);
        }

    }

    /**
     * void for checking course enrollment
     */
    private void checkCourseEnrolled(){
        System.out.print("Enter student ID to search: ");
        try {
            int studentID = scanner.nextInt();
            if (findStudentByID(studentID) == null) {
                throw new InvalidUserInput("Invalid student ID.");
            }
            else{
                System.out.printf("Student %s is enrolled in the following courses (empty if none): %n", studentID);
                for (Course course : courses) {
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
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
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
        for (Student student : students) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }
}

