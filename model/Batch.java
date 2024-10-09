package model;

import java.util.ArrayList;

public class Batch {
    private String batchName;
    private String dateCreated;
    private Feedback feedbackTemplate=new Feedback();
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Feedback> feedbackList = new ArrayList<>();
    private boolean isActive;


    //constructor
    public Batch(String batchName) {
        this.batchName = batchName;
        this.dateCreated=java.time.LocalDate.now().toString();
        this.isActive=true;
    }

    //getter setter
    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Feedback getFeedbackTemplate() {
        return feedbackTemplate;
    }

    public void setFeedbackTemplate(Feedback feedbackTemplate) {
        this.feedbackTemplate = feedbackTemplate;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(ArrayList<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
    //behaviors
    public void addStudent(Student student){
        studentList.add(student);
    }
    public void addFeedback(Feedback feedback){
        feedbackList.add(feedback);
    }
}
