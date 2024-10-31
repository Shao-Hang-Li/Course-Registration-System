package CourseRegistrationSystem;

//Defining custom Exception that is thrown when invalid choice is given by user
// Reference: It was taken from Java_HOLs_09 (custom_exceptions) and we used it for UserInput instead of InvalidAgeException

public class InvalidUserInput extends RuntimeException{

    //allowing custom message
    public InvalidUserInput(String message) {
        super(message);        
    }

    //supports exception throw
    public InvalidUserInput(String message, Throwable cause) {
        super(message, cause);
    }
}
