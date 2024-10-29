package CourseRegistrationSystem;

import java.util.*;

public class CourseRegistration {
    private final ArrayList<Course> courses = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void addCourse() {

        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter professor name: ");
        String professor = scanner.nextLine();
            //max seats if needed
                /*try {
                    System.out.printf("Enter Max amount of seats: ");
                    maxSeat = input.nextInt();
                    if (maxSeat <= 0) {
                        throw new InvalidUserInput("Max number of seats cannot be zero or negative!");
                    }
                    else{//cases if no exceptrion was thrown
                        Course aCourse = new Course(courseCode, courseName, instructor, maxSeats);//waiting for course.java to be updated
                        
                        //TO DO: add to ArrayList and display






                    }
                } catch (Exception e) {
                    System.out.printf("%nException: %s %n", e);
                }*/
        
        courses.add(new Course(courseCode, courseName, professor));
        System.out.println("Course added successfully!");
    }

    //register student into a course
    public void registerStudent(){
        String courseName, courseCode, instructor, studentName;
        int maxSeat, studentNumber;
        System.out.printf("Enter student name: ");
        studentName = scanner.nextLine();

        System.out.printf("Enter student number: ");
        try {   //if user input is not an int, throw error message
            studentNumber = scanner.nextInt();

            System.out.printf("Enter course code: ");
            courseCode = scanner.next();

        } catch (Exception e) {
            System.out.printf("Exception: %s %n", e);//throw exception message
        }

        //TO DO: use the variables to register student into a course, remove unused variables later



    }

    //This method reads from arraylist and prints info for all courses.
    public void getAllCourses(){
        //TO DO: read from arraylist and print info for all courses. maybe for (type element_name : Array){} ?




    }

    public void addNewStudent(){
        String studentName;
        int studentNumber;
        System.out.printf("Enter student name: ");
        studentName = scanner.nextLine();

        System.out.printf("Enter student number: ");
        try {   //if user input is not an int, throw error message
            studentNumber = scanner.nextInt();

            students.add(new Student(studentName, studentNumber));
            System.out.printf("New student registered! Student Name: %s, Student Number: %d.%n", studentName, studentNumber);


        } catch (Exception e) {
            System.out.printf("Exception: %s %n", e);//throw exception message
        }


    }

    public void getAllStudents(){
        //TO DO: read from arraylist and print info for all students. maybe for (type element_name : Array){} ?

    }

    public void removeCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course code to remove: ");
        String courseCode = scanner.nextLine();
        
        Course course = findCourseByCode(courseCode);
        if (course != null) {
            courses.remove(course);
            System.out.println("Course " + courseCode + " removed successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }



}