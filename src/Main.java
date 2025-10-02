import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedBusSystem system = new MedBusSystem();

        System.out.println("=== Emergency MEDBUS System ===");
        while (true) {
            System.out.println("\n1. Raise Request\n2. View Requests\n3. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (ch) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter your Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();                
                    System.out.print("Enter location: ");
                    String location = sc.nextLine();
                    System.out.print("Enter contact number: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter emergency type (Accident, Cardiac, etc): ");
                    String emergency = sc.nextLine();

                    User user = new User(name, age, location, contact);
                    system.raiseRequest(user, emergency);
                    break;

                case 2:
                    system.viewRequests();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
