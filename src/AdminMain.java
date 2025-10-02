import java.util.*;

public class AdminMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MedBusSystem system = new MedBusSystem();

        System.out.println("=== MEDBUS ADMIN PANEL ===");
        while (true) {
            System.out.println("\n1. View All Requests\n2. Update Request Status\n3. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    system.viewRequests();
                    break;
 
                case 2:
                    System.out.print("Enter Request ID to update: ");
                    int reqId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status (In Progress / Dispatched / Completed): ");
                    String status = sc.nextLine();
                    system.updateRequestStatus(reqId, status);
                    break;

                case 3:
                    System.out.println("Exiting Admin Panel...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
