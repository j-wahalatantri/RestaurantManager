import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;


public class CLIManager{
    private static ArrayList<Employee> Employees = new ArrayList<>();
    public static void main(String[] args) {
        Scanner UserInput = new Scanner(System.in); // To receive user input
        boolean WhenToExit = false; // To exit the application

        DisplayWelcomeMessage();

        while(!WhenToExit) {
            DisplayOptions(); //
            try {
                System.out.println("Please enter your choice:");
                int UserChoice1 = UserInput.nextInt(); // Getting user input for the first menu
                UserInput.nextLine(); // To clear the user input received
                switch (UserChoice1) {
                    case 1:
                        System.out.println("Opening the Managing Restaurant page please wait!");
                        WhenToExit = true;
                        break;
                    case 2:
                        System.out.println("Opening the Managing Employees page");
                        ManageEmployees(UserInput);
                        break;
                    case 3:
                        WhenToExit = true;
                        break;
                    default:
                        System.out.println("Please try entering a valid choice!");
                }

            }
            catch (InputMismatchException e){
                System.out.println("Please enter one of the options available"); // For Exception handling
                UserInput.next();
            }
        }
        System.out.println("Thanking you for using Restaurant Management Console!!!");
        UserInput.close();



    }
    public static void DisplayWelcomeMessage() {
        System.out.println("!!! Welcome to the Restaurant Manangement Console !!!");
    }
    public static void DisplayOptions() {
        System.out.println("What would you like to do!");
        System.out.println("1.Manage Restaurants");
        System.out.println("2.Manage Employees");
        System.out.println("3.Exit the application");
    }
    public static void ManageEmployees(Scanner UserInput) {
        boolean BackToMainMenu = false;
        while (!BackToMainMenu) { // To return back to main menu
            DisplayEmployeeOptions(); //To display employee options
            try{
                System.out.println("Please enter your choice:");
                int UserChoice2 = UserInput.nextInt();
                UserInput.nextLine();
                switch(UserChoice2) {
                    case 1:
                        System.out.println("Enter the first name:");
                        String FirstName = UserInput.nextLine();
                        System.out.println("Enter the last name:");
                        String LastName = UserInput.nextLine();
                        System.out.println("Enter the position:");
                        String Position = UserInput.nextLine();
                        int id;
                        while (true){ // To receive data about an employee
                            System.out.println("Enter employee ID:");
                            if (UserInput.hasNextInt()) {
                                id = UserInput.nextInt();
                                UserInput.nextLine();
                                break;
                            }
                            else {
                                System.out.println("Please enter an integer value"); // exception handling
                                UserInput.nextLine();
                            }
                        }
                        Employees.add(new Employee(FirstName, LastName, Position, id));
                        System.out.println("Employee added to the record successfully!");
                        break;
                    case 2:
                        System.out.println("List of employees:"); //Browse for employees
                        for (Employee employee : Employees){
                            System.out.println("First Name:"+employee.getFirstName());
                            System.out.println("Last Name:"+employee.getLastName());
                            System.out.println("Position:"+employee.getPosition());
                            System.out.println("Employee ID:"+employee.getid());
                            System.out.println();
                        }
                        break;
                    case 3:
                        BackToMainMenu = true;
                        break;
                    case 4:
                        BackToMainMenu = true;
                        break;
                    default:
                        System.out.println("Pleae enter a valid choice");
                }

            }catch (InputMismatchException e){
                System.out.println("Please enter one of the options available");
            }
        }
    }
    public static void DisplayEmployeeOptions() {
        System.out.println("What would you like to do!");
        System.out.println("1.Add employees");
        System.out.println("2.Browse employees");
        System.out.println("3.Delete employees");
        System.out.println("4.Back to main menu");
    }
}
class Employee { //Array list
    private String FirstName;
    private String LastName;
    private String Position;
    private int id;

    Employee (String FirstName, String LastName, String Position, int id){
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Position = Position;
        this.id = id;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getPosition(){
        return Position;
    }
    public int getid(){
        return id;
    }

}