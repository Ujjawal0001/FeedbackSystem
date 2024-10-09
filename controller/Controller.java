package controller;

import model.Batch;
import model.Feedback;
import model.Student;
import uiclient.Message;
import Service.AdminService;
import Service.BatchService;
import Service.ServiceImpl.AdminServiceImpl;
import Service.ServiceImpl.BatchServiceImpl;
import Service.ServiceImpl.StudentServiceImpl;
import Service.StudentService;


import java.util.ArrayList;


public class Controller {
    StudentServiceImpl studentService=new StudentServiceImpl();
    AdminServiceImpl adminService=new AdminServiceImpl();
    BatchServiceImpl batchService = new BatchServiceImpl();

    public boolean signUp(String name, String phoneNumber, String password, String role, Message msg){
        if(role.equalsIgnoreCase("admin"))
            return adminService.signUp(name,phoneNumber,password,msg);
        else
            return studentService.signUp(name,phoneNumber,password,adminService,msg);
    }
    public boolean adminSignIn(String phoneNumber, String password, Message msg){
        return adminService.signIn(phoneNumber,password,msg);
    }
    public boolean studentSignIn(String phoneNumber, String password, Message msg){
        return studentService.signIn(phoneNumber,password,msg);
    }
    public boolean signIn(String phoneNumber,String password,String role,Message msg){
        if(role.equalsIgnoreCase("admin"))
            return adminService.signIn(phoneNumber,password,msg);
        else
            return studentService.signIn(phoneNumber,password,msg);
    }

    public Student fetchStudent(String studentPhoneNumber){
        return studentService.fetchStudent(studentPhoneNumber);
    }

    public boolean createBatch(String batchName,Message msg){
        return batchService.createBatch(batchName,msg);
    }

    public Batch fetchBatch(String batchName){
        return batchService.fetchBatch(batchName);
    }

    public boolean isStudent(String phoneNumber){
        return studentService.isStudent(phoneNumber);
    }
    public boolean isBatch(String batchName){
        return batchService.isBatch(batchName);
    }
    public boolean deleteBatch(String batchName,Message msg){
        return  batchService.deleteBatch(batchName,msg);
    }
    public boolean assignBatch(String studentPhoneNumber,String batchName,Message msg){

        return batchService.assignBatch(studentPhoneNumber,batchName,studentService,msg);

    }

    public boolean addQuestion(String batchName, String newQuestion, Message msg){
        return batchService.addQuestion(batchName,newQuestion,msg);
    }



    public boolean editQuestion(String batchName,int questionNumber,String editedQuestion,Message msg){
        return batchService.editQuestion(batchName,questionNumber,editedQuestion,msg);
    }

    public boolean deleteQuestion(String batchName,int questionNumber,Message msg){
        return batchService.deleteQuestion(batchName,questionNumber,msg);
    }

    public ArrayList<Feedback> getStudentFeedback(String studentPhoneNumber){
        return studentService.getStudentFeedback(studentPhoneNumber);
    }

    public ArrayList<Feedback> getBatchFeedbackList(String batchName){
            return batchService.getBatchFeedbackList(batchName);
    }

    public Feedback getBatchFeedbackTemplate(String batchName){
        return batchService.getBatchFeedbackTemplate(batchName);
    }

    public boolean submitFeedback(Feedback studentFeedback,String batchName){
        return batchService.submitFeedback(studentFeedback,batchName,studentService);
    }
    public ArrayList<Student> getStudentByBatchName(String batchName,Message message){
        return batchService.getStudentsByBatchName(batchName,message);
    }
    public ArrayList<Student> getStudentList(){
        return studentService.getStudentList();
    }

    public ArrayList<Batch> getBatchList(){
        return batchService.getBatchList();
    }
}
