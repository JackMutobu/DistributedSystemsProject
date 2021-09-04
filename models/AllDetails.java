package models;

public class AllDetails extends ModelMessage {

    private Message message;
    private Faculty faculty;
    private StudentName sName;
    private StudentNumber sNumber;

    public AllDetails(Message message,Faculty faculty,StudentName sName,StudentNumber sNumber) {
        super();
        this.message = message;
        this.faculty = faculty;
        this.sName = sName;
        this.sNumber = sNumber;
    }

    public Message getMessage() {
        return message;
    }
    public void setMessage(Message message) {
        this.message = message;
    }

    public Faculty getFaculty() {
        return faculty;
    }
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public StudentNumber getStudentNumber() {
        return sNumber;
    }
    public void setStudentNumber(StudentNumber sNumber) {
        this.sNumber = sNumber;
    }

    public StudentName getStudentName() {
        return sName;
    }
    public void setStudentName(StudentName sName) {
        this.sName = sName;
    }
}
