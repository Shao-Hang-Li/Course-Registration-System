package CourseRegistrationSystem;

//Defining custom Exception that is thrown when invalid choice is given by user

public class InvalidChoiceException extends RuntimeException{
    public InvalidChoiceException(String message) {
        super(message);        
    }

    public InvalidChoiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
