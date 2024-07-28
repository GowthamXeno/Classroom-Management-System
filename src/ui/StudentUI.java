package ui;

import services.StudentService;

import java.util.Scanner;

public class StudentUI {
    private StudentService studentService = new StudentService();
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.print("Enter your ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter your DOB (yyyy-mm-dd): ");
        String dob = scanner.nextLine();

        if (studentService.authenticate(id, dob) == null) {
            System.out.println("Invalid ID or DOB. Access denied.");
            return;
        }

        while (true) {
            System.out.println("1. View Personal Details");
            System.out.println("2. Provide Feedback");
            System.out.println("3. Mark Attendance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    studentService.viewPersonalDetails(id);
                    break;
                case 2:
                    studentService.provideFeedback();
                    break;
                case 3:
                    studentService.markAttendance(id);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
