package models;


public class StudentName extends ModelMessage {
    private String firstName,surname;

    public String getName() {
        return firstName+" "+surname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
