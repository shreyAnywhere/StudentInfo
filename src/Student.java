import java.util.ArrayList;
import java.util.List;

public class Student {

    private int rollNumber;
    private String name;
    private String surname;
    private int std;
    private String div;
    private List<Long> phoneNumbers = new ArrayList<>();
    private List<String> emailID = new ArrayList<>();

    public Student() {
    }

    public Student(int rollNumber, String name, String surname, int std, String div, List<Long> phoneNumber, List<String> emailID) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.surname = surname;
        this.std = std;
        this.div = div;
        this.phoneNumbers = phoneNumber;
        this.emailID = emailID;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStd() {
        return std;
    }

    public void setStd(int std) {
        this.std = std;
    }

    public String getDiv() {
        return div;
    }

    public void setDiv(String div) {
        this.div = div;
    }

    public List<Long> getPhoneNumber() {
        return phoneNumbers;
    }

    public void setPhoneNumber(List<Long> phoneNumber) {
        this.phoneNumbers = phoneNumber;
    }

    public List<String> getEmailID() {
        return emailID;
    }

    public void setEmailID(List<String> emailID) {
        this.emailID = emailID;
    }

    public String getFullName() {
        return name + " " + surname;
    }
}
