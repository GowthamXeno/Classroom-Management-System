package ui;

import services.AdminService;

import java.util.Scanner;

public class AdminUI {
    private AdminService adminService = new AdminService();
    private Scanner scanner = new Scanner(System.in);

   
    public void showMenu() {
        System.out.print("Enter admin password: ");
        String password = scanner.nextLine();

        if (!adminService.authenticate(password)) {
            System.out.println("Invalid password. Access denied.");
            return;
        }

        while (true) {
            System.out.println("1. View and Edit Staff Details");
            System.out.println("2. View and Edit Student Details");
            System.out.println("3. Edit Schedules");
            System.out.println("4. Hire New Staff");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminService.viewAndEditStaffDetails();
                    break;
                case 2:
                    adminService.viewAndEditStudentDetails();
                    break;
                case 3:
                    adminService.editSchedules();
                    break;
                case 4:
                    adminService.hireStaff();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
