
import java.io.Console;
import java.util.*;

public class Main {

    public static List<Student> studentList = new ArrayList<>();
    public static Map<Integer, Boolean> rollNumberVisited = new HashMap<>();
    public static void main(String[] args) {

        while(true)
        {
            //Console console = System.console();
            Scanner scanner = new Scanner(System.in);

            System.out.println("1.Add new student 2.Display all students 3.Display the student with given roll number 4.Delete a student 5.Exit");
            int input = scanner.nextInt();

            if(input == 1) {
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

                Student student = new Student(rollNumber, name, surname, std, div);
                studentList.add(student);
            }
            else if(input == 2){

                if(studentList.isEmpty()){
                    System.out.println("There is no student registered.");
                    continue;
                }
                for(Student obj : studentList)
                    System.out.println("Name:" + obj.getFullName() + " Standard:" + obj.getStd() + " Division:" + obj.getDiv());
            }
            else if(input == 3){
                System.out.println("Enter the rollnumber:");
                int inputRollNumber = scanner.nextInt();

                if(rollNumberVisited.get(inputRollNumber)  == null){
                    System.out.println("Entered rollnumber is not registered.");
                }
                else {
                    for(Student obj : studentList)
                    {
                        if(obj.getRollNumber() == inputRollNumber)
                        {
                            System.out.println("Name:" + obj.getFullName() + " Standard:" + obj.getStd() + " Division:" + obj.getDiv());
                            break;
                        }
                    }
                }
            }
            else if(input == 4){
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
            }
            else
                break;
        }
    }
}
