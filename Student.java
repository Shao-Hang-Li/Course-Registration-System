class Student {
    private int studentID;
    private String studentFirstName;
    private String studentLastName;

    public Student(String studentFirstName, String studentLastName, int studentID) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentFirstName;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

}