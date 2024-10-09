package model;

import java.util.ArrayList;

public class Feedback {
    private String date;
    private  String studentPhoneNumber;
    private String studentName;
    private ArrayList<Question> questionList = new ArrayList<>();

    //constructor
    public Feedback() {
        questionList.add(new Question("Did the teacher listened to you doubts?"));
        questionList.add(new Question("Did you understand the topic taught in today's class?"));
        questionList.add(new Question("Are you satisfied with today's class?"));
    }
    //copy constructor
    public Feedback(Feedback feedbackTemplate,String studentPhoneNumber,String studentName){
        this.questionList.addAll(feedbackTemplate.getQuestionList());
        this.studentPhoneNumber=studentPhoneNumber;
        this.studentName=studentName;
        this.date=java.time.LocalDate.now().toString();
    }

    //getter setter
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }
}
