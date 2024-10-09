package Service.ServiceImpl;

import model.Admin;
import model.Feedback;
import model.Student;
import repository.impl.StudentRepositoryImpl;
import uiclient.Message;
import Service.StudentService;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService {
   private StudentRepositoryImpl studentRepoimpl = StudentRepositoryImpl.getInstance();

   // singelton design pattern - most frequent asked interview questions

    private static StudentServiceImpl instance;

    public static synchronized StudentServiceImpl getInstance() {
        if(instance == null) {
            instance = new StudentServiceImpl();
        }
         return instance;
    }

    // bad design
    public boolean signUp(String name , String phoneNumber , String password , AdminServiceImpl adminService, Message msg){
      Student student= studentRepoimpl.fetchStudent(phoneNumber);
      boolean isAdmin=adminService.isAdmin(phoneNumber);
       if(student!=null||isAdmin){
           msg.setMessage("Phone Number already registered as student or admin");
           return false;
       }
       else{
           Student student1 = new Student(name,phoneNumber,password);
           studentRepoimpl.save(student1);
       }
       return true;
    }
    public boolean signIn(String studentPhoneNumber , String password , Message msg){
        Student student=studentRepoimpl.fetchStudent(studentPhoneNumber);
        boolean isStudent=studentRepoimpl.isStudent(studentPhoneNumber);
        if(isStudent) {
            if (student != null) {
                if (password.equals(student.getPassword()))
                    return true;
            } else {
                msg.setMessage("wrong password");
                return false;
            }
        }
        msg.setMessage("User not found");
        return false;
    }

    public Student  fetchStudent(String studentPhoneNumber){
        Student student = studentRepoimpl.fetchStudent(studentPhoneNumber);
        if(student!=null){
            return student;
        }
        else{
            return null;
        }
    }

    public boolean isStudent(String phoneNumber){
        boolean isStudent=studentRepoimpl.isStudent(phoneNumber);
        if(isStudent){
            return true;
        }
        else{
            return false;
        }
    }


   public ArrayList<Feedback> getStudentFeedback(String studentPhoneNumber){
        boolean isStudent = studentRepoimpl.isStudent(studentPhoneNumber);
        if(isStudent){
            return studentRepoimpl.getStudentFeedback(studentPhoneNumber);
        }
        else{
            return null;
        }
    }

    public ArrayList<Student> getStudentList(){
        return studentRepoimpl.getStudentList();
    }
}
