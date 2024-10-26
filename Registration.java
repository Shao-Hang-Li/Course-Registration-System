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
    //and an string array that include course number, number of spots, course name and teacher
    //and returns a boolean indicating if registration is available
    public boolean enrollNewStudent(String[] student, String[] course){
        int spotsAvailable = Integer.valueOf(course[1]) ;
        if (spotsAvailable > 0) {
            System.out.printf("Your Registration has been complete and recorded for %s!%n", course[2]);
            return true;
        }
        else{
            System.out.printf("There are not enough seats available in course %s! Registration Failed!%n", course[2]);
            return false;
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