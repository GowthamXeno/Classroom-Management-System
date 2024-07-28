package services;

import models.Student;
import utils.CSVUtils;

import java.util.List;
import java.util.Scanner;

public class StudentService {

    public Student authenticate(String id, String dob) {
        List<Student> students = CSVUtils.readStudents();
        for (Student student : students) {
            if (student.getId().equals(id) && student.getDob().equals(dob)) {
                return student;
            }
        }
        return null;
    }

    public void viewPersonalDetails(String studentId) {
        List<Student> students = CSVUtils.readStudents();
        for (Student student : students) {
            if (student.getId().equals(studentId)) {
            }
        }
    }
    public void admitStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student DOB (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        String age = scanner.nextLine();
        System.out.print("Enter Student Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Student Blood Group: ");
        String bloodGroup = scanner.nextLine();

        Student newStudent = new Student(id, name, dob, age, address, bloodGroup);
        List<Student> students = CSVUtils.readStudents();
        students.add(newStudent);
        CSVUtils.writeStudents(students);

        System.out.println("Student admitted successfully.");
    }

    public void provideFeedback() {
    }

    public void markAttendance(String studentId) {
    }

    public void newAdmission(Student student) {
        List<Student> students = CSVUtils.readStudents();
        students.add(student);
        CSVUtils.writeStudents(students);
    }

    public void scheduleClassForStaff() {
    }
}
