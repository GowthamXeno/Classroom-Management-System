import services.AdminService;
import services.StudentService;
import utils.CSVUtils;
import ui.AdminUI;
import ui.StaffUI;
import ui.StudentUI;
import models.Admin;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    // private static AdminService adminService = new AdminService();
    // private static StudentService studentService = new StudentService();

    public static void main(String[] args) {
        // Initialize admin if not already present
        initializeAdmin();

        while (true) {
            System.out.println("Select User Type:");
            System.out.println("1. Admin");
            System.out.println("2. Staff");
            System.out.println("3. Student");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    new AdminUI().showMenu();
                    break;
                case 2:
                    new StaffUI().showMenu();
                    break;
                case 3:
                    new StudentUI().showMenu();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void initializeAdmin() {
        List<Admin> admins = CSVUtils.readAdmins();
        if (admins.isEmpty()) {
            System.out.println("No admins found. Adding the first admin.");
            addAdmin();
        }
    }

    private static void addAdmin() {
        System.out.print("Enter Admin ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Admin Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        Admin newAdmin = new Admin(id, name, password);
        List<Admin> admins = CSVUtils.readAdmins();
        admins.add(newAdmin);
        CSVUtils.writeAdmins(admins);

        System.out.println("Admin added successfully.");
    }
}
