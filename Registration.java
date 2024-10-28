package CourseRegistrationSystem;
/**
 * registration System by Qi He, Shaohang Li, John Nicholas
 * 
 * This class performs registration management.
 * It contains the following methods:
 * 1. enroll new student
 * 2. get spots left
 * 3. get registration detail for a course from course number
 */
public class Registration {

    //This method take an string array that include Student Name, Student Number
    //and an string array that include course number, course name, professor, max amount of seats, students enrolled
    //and updates the course info if registration suceeded
    public void enrollNewStudent(String[] student, String[] course){
        //initialize variables for future use in the method
        int studentEnrolled = Integer.valueOf(course[4]);
        int maxSeat = Integer.valueOf(course[3]);
        int spotsAvailable = maxSeat - studentEnrolled;

        //case if there are enough spots
        if (spotsAvailable > 0) {
            System.out.printf("Your Registration has been complete and recorded for %s!%n", course[1]);
            course[4] = String.valueOf(studentEnrolled += 1);
        }

        //case if there are not enough spots
        else{
            System.out.printf("There are not enough seats available in course %s! Registration Failed!%n", course[1]);
        }
    }

    //The method take an string array that include course number, number of spots, course name and teacher
    //and returns number os seats available
    public int getSeatsAvailable(String[] course){
        
        System.out.printf("The number of Seats available in %s is %s. %n",course[2], course[1]);
        return Integer.valueOf(course[1]);

    }

    public void getDetail(String[] course){
        //TBD
    }
    
}