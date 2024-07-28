package services;

import models.Admin;
import models.Staff;
import models.Student;
import utils.CSVUtils;

import java.util.List;
import java.util.Scanner;

public class AdminService {

    // Authenticate an admin by checking password against the list of admins
    public boolean authenticate(String password) {
        List<Admin> admins = CSVUtils.readAdmins();
        for (Admin admin : admins) {
            if (admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // View and edit staff details
    public void viewAndEditStaffDetails() {
        List<Staff> staffs = CSVUtils.readStaffs();
        if (staffs.isEmpty()) {
            System.out.println("No staff found.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        // Display staff details
        for (int i = 0; i < staffs.size(); i++) {
            Staff staff = staffs.get(i);
            System.out.println((i + 1) + ". ID: " + staff.getId() + ", Name: " + staff.getName() + ", DOB: "
                    + staff.getDob() + ", Age: " + staff.getAge() + ", Address: " + staff.getAddress());
        }

        System.out.print("Enter the number of the staff to edit (or 0 to cancel): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= staffs.size()) {
            Staff staffToEdit = staffs.get(choice - 1);
            System.out.print("Enter new Name (leave empty to keep current): ");
            String name = scanner.nextLine();
            System.out.print("Enter new DOB (leave empty to keep current): ");
            String dob = scanner.nextLine();
            System.out.print("Enter new Age (leave empty to keep current): ");
            String age = scanner.nextLine();
            System.out.print("Enter new Address (leave empty to keep current): ");
            String address = scanner.nextLine();

            if (!name.isEmpty())
                staffToEdit.setName(name);
            if (!dob.isEmpty())
                staffToEdit.setDob(dob);
            if (!age.isEmpty())
                staffToEdit.setAge(age);
            if (!address.isEmpty())
                staffToEdit.setAddress(address);

            CSVUtils.writeStaffs(staffs);
            System.out.println("Staff details updated successfully.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // View and edit student details
    public void viewAndEditStudentDetails() {
        List<Student> students = CSVUtils.readStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        Scanner scanner = new Scanner(System.in);

        // Display student details
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println((i + 1) + ". ID: " + student.getId() + ", Name: " + student.getName() + ", DOB: "
                    + student.getDob() + ", Age: " + student.getAge() + ", Address: " + student.getAddress()
                    + ", Blood Group: " + student.getBloodGroup());
        }

        System.out.print("Enter the number of the student to edit (or 0 to cancel): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice > 0 && choice <= students.size()) {
            Student studentToEdit = students.get(choice - 1);
            System.out.print("Enter new Name (leave empty to keep current): ");
            String name = scanner.nextLine();
            System.out.print("Enter new DOB (leave empty to keep current): ");
            String dob = scanner.nextLine();
            System.out.print("Enter new Age (leave empty to keep current): ");
            String age = scanner.nextLine();
            System.out.print("Enter new Address (leave empty to keep current): ");
            String address = scanner.nextLine();
            System.out.print("Enter new Blood Group (leave empty to keep current): ");
            String bloodGroup = scanner.nextLine();

            if (!name.isEmpty())
                studentToEdit.setName(name);
            if (!dob.isEmpty())
                studentToEdit.setDob(dob);
            if (!age.isEmpty())
                studentToEdit.setAge(age);
            if (!address.isEmpty())
                studentToEdit.setAddress(address);
            if (!bloodGroup.isEmpty())
                studentToEdit.setBloodGroup(bloodGroup);

            CSVUtils.writeStudents(students);
            System.out.println("Student details updated successfully.");
        } else {
            System.out.println("Invalid choice.");
        }
    }

    // Hire a new staff member
    public void hireStaff() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Staff ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Staff DOB (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Staff Age: ");
        String age = scanner.nextLine();
        System.out.print("Enter Staff Address: ");
        String address = scanner.nextLine();

        Staff newStaff = new Staff(id, name, dob, age, address);
        List<Staff> staffs = CSVUtils.readStaffs();
        staffs.add(newStaff);
        CSVUtils.writeStaffs(staffs);

        System.out.println("Staff hired successfully.");
    }

    // Edit schedules (method implementation needed)
    public void editSchedules() {
        System.out.println("Edit schedules functionality not implemented.");
    }
}
