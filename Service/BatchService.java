package Service;

import model.Batch;
import model.Feedback;
import model.Student;
import uiclient.Message;
import Service.ServiceImpl.StudentServiceImpl;

import java.util.ArrayList;

public interface BatchService {
    boolean createBatch(String batchName , Message msg);
    boolean assignBatch(String batchName , String studentPhoneNumber , StudentServiceImpl studentService , Message msg);
    ArrayList<Batch> fetchBatchList();
    ArrayList<Student> viewStudentList(String batchName , Message message);
    Batch  fetchBatch(String batchName);
    boolean isBatch(String batchName);
    boolean deleteBatch(String batchName, Message message);
    boolean addQuestion(String batchName, String newQuestion, Message msg);
    boolean editQuestion(String batchName,int questionNumber,String editedQuestion,Message msg);
    boolean deleteQuestion(String batchName,int questionNumber,Message msg);
    ArrayList<Feedback> getBatchFeedbackList(String batchName);
    Feedback getBatchFeedbackTemplate(String batchName);
    boolean submitFeedback(Feedback studentFeedback,String batchName,StudentServiceImpl studentService);
    ArrayList<Student> getStudentsByBatchName(String batchName,Message message);
    ArrayList<Batch> getBatchList();
}
