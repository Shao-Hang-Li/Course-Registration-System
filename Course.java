package CourseRegistrationSystem;

public class Course {
    //Variables and types declaration for Course
    private final String courseCode;
    private final String courseName;
    private final String professor;
    private final int maxNumberStudents;
    private int courseEnrolled;

    public Course(String courseCode, String courseName, String professor, int maxNumberStudents, int courseEnrolled) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
        this.maxNumberStudents = maxNumberStudents;
        this.courseEnrolled = courseEnrolled;
    }

    public void setCourseEnrolled(int anInt){
        this.courseEnrolled = anInt;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }
    
    public String getProfessor() {
        return professor;
    }

    public int getMaxNumberStudents() {
        return maxNumberStudents;
    }

    public int getCourseEnrolled() {
        return courseEnrolled;
    }
}


//Notes: This is just the beginning, I am not sure yet if I want to add more features such as schedule, etc. But I will start with this and work my way up later.