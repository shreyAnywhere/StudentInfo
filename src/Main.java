
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args) {

        int input = 1;
        while(true)
        {
            //Console console = System.console();
            Scanner scanner = new Scanner(System.in);

            System.out.println("1.Add new student 2.Display all students 3.Exit");
            input = scanner.nextInt();

            if(input == 1) {
                System.out.println("Enter rollnumber:");
                int rollNumber = scanner.nextInt();
                System.out.println("Enter name:");
                String name = scanner.next();
                System.out.println("Enter surname:");
                String surname = scanner.next();
                System.out.println("Enter standard:");
                int std = scanner.nextInt();
                System.out.println("Enter division:");
                String div = scanner.next();

                Student student = new Student(rollNumber, name, surname, std, div);
                studentList.add(student);
            }
            else if(input == 2){
                for(Student obj : studentList)
                    System.out.println(obj.getName());
            }
            else
                break;
        }
    }
}
