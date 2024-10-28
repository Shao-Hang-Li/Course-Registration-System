package CourseRegistrationSystem;

import java.util.Scanner;

public class UserInteraction {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); //initialize scanner to gain input
        int userInput = 0;
        String courseName, courseCode, instructor;
        int maxSeat;


        //include everything in a while loop to make sure it loops if the user input is not 6
        while (userInput != 6) {
            //display menu, since no variable is userd, we use println instead for formatting purpose
            System.out.println();
            System.out.println("Course Registration System");
            System.out.println("1. Add Course");
            System.out.println("2. Register Student");
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
                break;//leaves the cycle
            }



            //user selection

            //add course
            if (userInput == 1) {
                System.out.printf("Enter course name: ");
                courseName = input.next();

                System.out.printf("Enter course code: ");
                courseCode = input.next();
                input.nextLine(); //consumes the newline symbol so nextline doesn't pick it up

                System.out.printf("Enter Instructor name: ");
                instructor = input.nextLine();

                //If input is not a int or a negative number, raise exception
                try {
                    System.out.printf("Enter Max amount of seats: ");
                    maxSeat = input.nextInt();
                    if (maxSeat <= 0) {
                        throw new InvalidUserInput("Max number of seats cannot be zero or negative!");
                    }
                } catch (Exception e) {
                    System.out.printf("%nException: %s %n", e);
                    break;//leave the cycle
                }
                Course aCourse = new Course(courseCode, courseName, instructor, maxSeat); 
                //waiting for course.java to be updated
                //TO DO: add to ArrayList and diplay

            }
            //register student
            else if (userInput == 2) {
                
            }
            //display courses
            else if (userInput == 3) {
                
            }
            //add student
            else if (userInput == 4) {
                
            }
            //display student
            else if (userInput == 5) {
                
            }
            //exit option is not needed as all it does is leaving and will automatically end the while loop.
        }
        input.close();
    }
}
