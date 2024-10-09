package repository;

import model.Feedback;
import model.Student;

import java.util.ArrayList;

public interface StudentRepository {
    ArrayList<Student> studentList =new ArrayList<>();

    boolean save(Student student);

    boolean isStudent(String phoneNumber);

    Student fetchStudent(String phoneNumber);

    ArrayList<Feedback> getStudentFeedback(String studentPhoneNumber);

    ArrayList<Student> getStudentList();
}
