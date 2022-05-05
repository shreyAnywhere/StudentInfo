
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static List<Student> studentList = new ArrayList<>();
    public static Map<Integer, Boolean> rollNumberVisited = new HashMap<>();
    public static Map<Long, Boolean> phoneNumberVisited = new HashMap<>();
    public static Map<String, Boolean> emailIDVisited = new HashMap<>();

    public static boolean checkPhoneNumber(long phoneNumber){
        int numOfDigits = 0;

        while(phoneNumber != 0)
        {
            phoneNumber = phoneNumber/10;
            numOfDigits++;
        }

        return numOfDigits == 10;
    }

    public static boolean checkEmailID(String emailID){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(emailID);

        return matcher.matches();
    }

    public static void main(String[] args) {

        while(true)
        {
            //Console console = System.console();
            Scanner scanner = new Scanner(System.in);

            System.out.println("1.Add new student 2.Display all students 3.Display the student with given information 4.Delete a student 5.Exit");
            int input = scanner.nextInt();

            switch (input){
                case 1:
                    System.out.println("Enter rollnumber:");
                    int rollNumber = scanner.nextInt();
                    while(rollNumberVisited.get(rollNumber) != null)
                    {
                        System.out.println("This rollnumber is already in use. Create differnt one.");
                        rollNumber = scanner.nextInt();
                    }
                    rollNumberVisited.put(rollNumber, true);

                    System.out.println("Enter name:");
                    String name = scanner.next();

                    System.out.println("Enter surname:");
                    String surname = scanner.next();

                    System.out.println("Enter standard:");
                    int std = scanner.nextInt();
                    while(!(std>=1 && std<=12)){
                        System.out.println("Enter valid standard");
                        std = scanner.nextInt();
                    }

                    System.out.println("Enter division:");
                    String div = scanner.next();

                    long phoneNumber = 0;
                    System.out.println("How many phone number you want add?");
                    int numOfPhoneNumbers = scanner.nextInt();
                    List<Long> phoneNumberList = new ArrayList<>();
                    for(int i=0;i<numOfPhoneNumbers;i++){
                        while(true){
                            System.out.println("Enter phone number:");
                            phoneNumber = scanner.nextLong();
                            if(!checkPhoneNumber(phoneNumber)){
                                System.out.println("Phone number is not valid. Enter a valid one.");
                                continue;
                            }
                            else if(phoneNumberVisited.get(phoneNumber) != null){
                                System.out.println("Phone number is already been registered.");
                                continue;
                            }
                            phoneNumberVisited.put(phoneNumber, true);
                            phoneNumberList.add(phoneNumber);
                            break;
                        }
                    }

                    String emailID = "";
                    System.out.println("How many email IDs you want add?");
                    int numOfEmailIDs = scanner.nextInt();
                    List<String> emailIDList = new ArrayList<>();
                    for(int i=0;i<numOfEmailIDs;i++){
                        while(true) {
                            System.out.println("Enter email ID:");
                            emailID = scanner.next();
                            if(!checkEmailID(emailID)){
                                System.out.println("EmailID is not valid. Enter a valid one.");
                                continue;
                            }
                            else if(emailIDVisited.get(emailID) != null){
                                System.out.println("EmailID is already been registered.");
                                continue;
                            }
                            emailIDVisited.put(emailID, true);
                            emailIDList.add(emailID);
                            break;
                        }
                    }

                    Student student = new Student(rollNumber, name, surname, std, div, phoneNumberList, emailIDList);
                    studentList.add(student);
                    break;
                case 2:
                    if(studentList.isEmpty()){
                        System.out.println("There is no student registered.");
                        continue;
                    }
                    for(Student obj : studentList)
                        System.out.println("Name:" + obj.getFullName() + " Standard:" + obj.getStd() + " Division:" + obj.getDiv());
                    break;
                case 3:
                    System.out.println("Enter the 1.roll number 2.emailID 3.phone number:");
                    int userInput = scanner.nextInt();

                    switch (userInput) {
                        case 1 -> {
                            System.out.println("enter roll number");
                            int userInputRollNumber = scanner.nextInt();
                            if (rollNumberVisited.get(userInputRollNumber) == null) {
                                System.out.println("Entered roll number is not registered.");
                            } else {
                                for (Student obj : studentList) {
                                    if (obj.getRollNumber() == userInputRollNumber) {
                                        System.out.println("Name:" + obj.getFullName() + " Standard:" + obj.getStd() + " Division:" + obj.getDiv());
                                        break;
                                    }
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("enter emailID");
                            String userEmailID = scanner.next();
                            if (emailIDVisited.get(userEmailID) == null) {
                                System.out.println("Entered email ID is not registered.");
                            } else {
                                Break:
                                for (Student obj : studentList) {
                                    for (int i = 0; i < obj.getEmailID().size(); i++) {
                                        if (Objects.equals(userEmailID, obj.getEmailID().get(i))) {
                                            System.out.println("Name:" + obj.getFullName() + " Standard:" + obj.getStd() + " Division:" + obj.getDiv());
                                            break Break;
                                        }
                                    }
                                }
                            }
                        }
                        case 3 -> {
                            System.out.println("enter phone number:");
                            long userPhoneNumber = scanner.nextLong();
                            if (phoneNumberVisited.get(userPhoneNumber) == null) {
                                System.out.println("Entered phone number is not registered.");
                            } else {
                                Break:
                                for (Student obj : studentList) {
                                    for (int i = 0; i < obj.getPhoneNumber().size(); i++) {
                                        if (userPhoneNumber == obj.getPhoneNumber().get(i)) {
                                            System.out.println("Name:" + obj.getFullName() + " Standard:" + obj.getStd() + " Division:" + obj.getDiv());
                                            break Break;
                                        }
                                    }
                                }
                            }
                        }
                    }

                    break;
                case 4:
                    System.out.println("Enter the roll number:");
                    int inputRollNumber = scanner.nextInt();

                    if(rollNumberVisited.get(inputRollNumber)  == null){
                        System.out.println("Entered rollnumber is not registered.");
                    }
                    else{
                        for(int i=0;i<studentList.size();i++){
                            Student obj = studentList.get(i);

                            if(obj.getRollNumber() == inputRollNumber){
                                studentList.remove(i);
                                break;
                            }
                        }
                    }
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
