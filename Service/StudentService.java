package Service;

import Service.ServiceImpl.AdminServiceImpl;
import model.Feedback;
import model.Student;
import uiclient.Message;

import java.util.ArrayList;

public interface StudentService {
    boolean signUp(String name , String phoneNumber , String password ,AdminServiceImpl adminService,  Message msg);
    boolean signIn(String phoneNumber , String password , Message msg);
    Student fetchStudent(String studentPhoneNumber);
    boolean isStudent(String phoneNumber);
    ArrayList<Feedback> getStudentFeedback(String studentPhoneNumber);
    ArrayList<Student> getStudentList();
}
