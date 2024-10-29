package CourseRegistrationSystem;

import java.util.Scanner;

public class UserInteraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //initialize scanner to gain input
        int userInput = 0;//initial value for while loop to use
        CourseRegistration registration = new CourseRegistration();


        //include everything in a while loop to make sure it loops if the user input is not 6
        while (userInput != 6) {
            //display menu, since no variable is userd, we use println instead for formatting purpose
            System.out.println();
            System.out.println("Course Registration System");
            System.out.println("1. Add Course");
            System.out.println("2. Register student into a course");
            System.out.println("3. Display courses");
            System.out.println("4. Add Student");
            System.out.println("5. Display Student");
            System.out.println("6. Exit");
            System.out.println(); //format

            //try to get user input, if input is not an int from 1 to 6, throws an exception and exit.
            try {
                System.out.printf("Choose an option: "); //used printf to not change to new line
                userInput = input.nextInt();
                if (userInput < 1 || userInput > 6) {
                    throw new InvalidUserInput("Please enter a valid input from 1-6!");
                }
            } catch (Exception e) { //catches all exceptions and displays corresponding message
                System.out.printf("Exception: %s %n", e);
            }



            //user selection

            //add course
            if (userInput == 1) {
                registration.addCourse();
            }

            //register student into a course
            else if (userInput == 2) {
                registration.registerStudent();
            }

            //display courses
            else if (userInput == 3) {
                registration.getAllCourses();
            }

            //add student
            else if (userInput == 4) {
                registration.addNewStudent();
            }

            //display student
            else if (userInput == 5) {
                registration.getAllStudents();
            }

            //exit option is not needed since all it does is leaving and will automatically end the while loop.
        }
        
        input.close();
    }
}
