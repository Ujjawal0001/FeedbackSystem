package model;

import java.util.ArrayList;

public class Student {
    private String name;
    private String phoneNumber;
    private String password;
    private String batchName;
    private String profilePhotoUrl;
    private boolean studentInBatch=false;
    ArrayList<Feedback> feedbackList=new ArrayList<>();
    //constructor
    public Student(String name, String phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    //getter setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }
    public boolean isStudentInBatch() {
        return studentInBatch;
    }

    public void setStudentInBatch(boolean studentInBatch) {
        this.studentInBatch = studentInBatch;
    }

    public ArrayList<Feedback> getFeedbackList() {
        return feedbackList;
    }

    //behavior
    public void addFeedback(Feedback feedback){
        feedbackList.add(feedback);
    }
}
