package services;

import models.Staff;
import models.Student;
import utils.CSVUtils;

import java.util.List;
import java.util.Scanner;

public class StaffService {

    public Staff authenticate(String id, String dob) {
        List<Staff> staffs = CSVUtils.readStaffs();
        for (Staff staff : staffs) {
            if (staff.getId().equals(id) && staff.getDob().equals(dob)) {
                return staff;
            }
        }
        return null;
    }

    public void viewAndEditStudentDetails() {
        List<Student> students = CSVUtils.readStudents();
        CSVUtils.writeStudents(students);
    }



    public void resolveFeedback() {
    }

    public void viewAttendance() {
    }

    public void viewCalendar() {
    }
}
