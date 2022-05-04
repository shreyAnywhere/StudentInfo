public class Student {

    private int rollNumber;
    private String name;
    private String surname;
    private int std;
    private String div;

    public Student() {
    }

    public Student(int rollNumber, String name, String surname, int std, String div) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.surname = surname;
        this.std = std;
        this.div = div;
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

    public String getFullName() {
        return name + " " + surname;
    }
}
