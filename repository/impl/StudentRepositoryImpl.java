package repository.impl;

import Service.ServiceImpl.StudentServiceImpl;
import model.Feedback;
import model.Student;
import repository.StudentRepository;

import java.util.ArrayList;

public class StudentRepositoryImpl implements StudentRepository {

    private static StudentRepositoryImpl instance;

    public static synchronized StudentRepositoryImpl getInstance() {
        if(instance == null) {
            instance = new StudentRepositoryImpl();
        }
        return instance;
    }

    public boolean save(Student student) {
        studentList.add(student);
        return true;
    }


    public boolean isStudent(String phoneNumber) {
        Student student=fetchStudent(phoneNumber);
        return student != null;

    }


    public Student fetchStudent(String phoneNumber) {
        for(Student student: studentList){
            if(student.getPhoneNumber().equals(phoneNumber))
                return student;
        }
        return null;
    }


    public ArrayList<Feedback> getStudentFeedback(String studentPhoneNumber) {
        Student student=fetchStudent(studentPhoneNumber);
        return student.getFeedbackList();
    }


    public ArrayList<Student> getStudentList() {
        return studentList;
    }
}
