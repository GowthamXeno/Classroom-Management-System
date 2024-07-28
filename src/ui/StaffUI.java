package ui;

import services.StaffService;
import services.StudentService;

import java.util.Scanner;

public class StaffUI {
    private StaffService staffService = new StaffService();
    private StudentService studentService = new StudentService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter your DOB (yyyy-mm-dd): ");
        String dob = scanner.nextLine();

        if (staffService.authenticate(id, dob) == null) {
            System.out.println("Invalid ID or DOB. Access denied.");
            return;
        }

        while (true) {
            System.out.println("1. View and Edit Student Details");
            System.out.println("2. Resolve Feedback");
            System.out.println("3. View Attendance");
            System.out.println("4. View Calendar");
            System.out.println("5. Admit New Student");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    staffService.viewAndEditStudentDetails();
                    break;
                case 2:
                    staffService.resolveFeedback();
                    break;
                case 3:
                    staffService.viewAttendance();
                    break;
                case 4:
                    staffService.viewCalendar();
                    break;
                case 5:
                    studentService.admitStudent();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
