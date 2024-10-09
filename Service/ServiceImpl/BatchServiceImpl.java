package Service.ServiceImpl;

import model.Batch;
import model.Feedback;
import model.Question;
import repository.impl.BatchRepositoryImpl;
import uiclient.Message;
import Service.BatchService;
import model.Student;

import java.util.ArrayList;
import java.util.Objects;

public class BatchServiceImpl implements BatchService {
    private BatchRepositoryImpl batchRepo = new BatchRepositoryImpl();
    public boolean createBatch(String batchName , Message msg){
        Batch batch=batchRepo.fetchBatch(batchName);
        if(batch!=null){
            if(!batch.isActive()){
                batch.setActive(true);
                return true;
            }
            msg.setMessage("Batch already exists");

            return false;
        }
        else{
            Batch batch1 = new Batch(batchName);
            batchRepo.save(batch1);

            return  true;
        }

    }
    public boolean assignBatch(String studentPhoneNumber , String batchName , StudentServiceImpl studentService , Message msg){
        Batch batch=batchRepo.fetchBatch(batchName);
        if(batch!=null&&batch.isActive()){
            Student student =studentService.fetchStudent(studentPhoneNumber);
            boolean isStudent=studentService.isStudent(studentPhoneNumber);

            if(student!=null){
               if(student.isStudentInBatch()){
                   msg.setMessage("Student already exists in batch");
                   return false;
               }
               else {
                   student.setBatchName(batchName);
//                 batchRepo.saveStudentTOBatch(student,batch);
                   batch.getStudentList().add(student);
                   student.setStudentInBatch(true);
                   return true;
               }
            }

            else{
                msg.setMessage("Student not found");
                return false;
            }
        }
        msg.setMessage("Batch not found");
        return false;
    }
    public ArrayList<Batch> fetchBatchList(){
       ArrayList<Batch> batchList= batchRepo.getBatchList();
       return batchList;
    }
    public ArrayList<Student> viewStudentList(String batchName , Message message){
        boolean isBatch=batchRepo.isBatch(batchName);
            if(isBatch){
                ArrayList<Student> studentList=batchRepo.fetchBatch(batchName).getStudentList();
                if(studentList!=null){
                    return studentList;
                }
                else {
                    message.setMessage("No student found");
                    return null;
                }
        }
            message.setMessage("No batch found");
            return null;
    }

    public Batch  fetchBatch(String batchName){
            return batchRepo.fetchBatch(batchName);
    }


    public boolean isBatch(String batchName){
        return batchRepo.isBatch(batchName);
    }
    public boolean deleteBatch(String batchName,Message message){

        boolean isBatch=batchRepo.isBatch(batchName);
        if(isBatch) {
            fetchBatch(batchName).setActive(false);
            return true;
        }
        else{
            message.setMessage("Batch not found!");
            return false;
        }
    }

    public boolean addQuestion(String batchName, String newQuestion, Message msg){
        boolean isBatch=batchRepo.isBatch(batchName);
        if(isBatch){
            Question question=new Question(newQuestion);
            batchRepo.fetchBatch(batchName).getFeedbackTemplate().getQuestionList().add(question);
            return true;
        }
        else{
            msg.setMessage("batch not found");
            return false;
        }
   }

    public boolean editQuestion(String batchName,int questionNumber,String editedQuestion,Message msg){
        boolean isBatch=batchRepo.isBatch(batchName);
        if(isBatch) {
            boolean isQuestion = batchRepo.isQuestion(questionNumber,batchRepo.fetchBatch(batchName));
                    if(isQuestion) {
                        Question question=new Question(editedQuestion);
                        batchRepo.fetchBatch(batchName).getFeedbackTemplate().getQuestionList().set(questionNumber-1,question);
                        return true;
                    }
                    else{
                         msg.setMessage("question not found");
                         return false;
            }
        }
        else{
            msg.setMessage("batch not found");
            return false;
        }
    }

    public boolean deleteQuestion(String batchName,int questionNumber,Message msg){
        boolean isBatch=batchRepo.isBatch(batchName);
        if(isBatch) {
            boolean isQuestion = batchRepo.isQuestion(questionNumber,batchRepo.fetchBatch(batchName));
            if(isQuestion) {
                batchRepo.deleteQuestion(batchRepo.fetchBatch(batchName), questionNumber);
                return true;
            }
            else{
                msg.setMessage("question not found");
                return false;
            }
        }
        else{
            msg.setMessage("batch not found");
            return false;
        }
    }

    public ArrayList<Feedback> getBatchFeedbackList(String batchName) {
        boolean isBatch = batchRepo.isBatch(batchName);
        if(isBatch){
            ArrayList<Feedback> feedBacks=batchRepo.fetchBatch(batchName).getFeedbackList();
            return  feedBacks;
        }
        else{
            return null;
        }
    }

    public Feedback getBatchFeedbackTemplate(String batchName) {
        boolean isBatch = batchRepo.isBatch(batchName);
        if(isBatch){
            Feedback feedbackTemplate=batchRepo.fetchBatch(batchName).getFeedbackTemplate();
            return feedbackTemplate;
        }
        else{
            return null;
        }
    }

    public boolean submitFeedback(Feedback studentFeedback,String batchName,StudentServiceImpl studentService) {
        boolean isBatch = batchRepo.isBatch(batchName);
        if(isBatch){
            batchRepo.fetchBatch(batchName).getFeedbackList().add(studentFeedback);
            studentService.fetchStudent(studentFeedback.getStudentPhoneNumber()).getFeedbackList().add(studentFeedback);
            return true;
        }
        else{
            return false;
        }
    }
    public ArrayList<Student> getStudentsByBatchName(String batchName,Message message){
        boolean isBatch = batchRepo.isBatch(batchName);
        if(isBatch){
            ArrayList<Student> students=batchRepo.fetchBatch(batchName).getStudentList();
            return students;

        }
        else{
            message.setMessage("Batch not found");
            return null;
        }
    }
    public ArrayList<Batch> getBatchList(){
        return batchRepo.getBatchList();
    }
}
