package uiclient;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.LocalDate;
import controller.Controller;
import model.Batch;
import model.Feedback;
import model.Question;
import model.Student;


public class CmdUiclient {
    static uiclient.Helper helper=new Helper();
    static Message msg=new Message();
    static Controller controller=new Controller();

    //populate Admin
    static {
        controller.signUp("Rishi Rich","7348891347","1234","admin",msg);
        controller.signUp("Pallavi Kumari","9693243217","1234","admin",msg);
        controller.signUp("Abhishek kumar jha","8622074071","1234","admin",msg);
        controller.signUp("Gaurav Kashyap","9113170895","1234","admin",msg);
    }
    //populate Student
    static {
        //for batch-1
        controller.signUp("Prabhakar","9798825716","1234","student",msg);
        controller.signUp("Anshal","7050577303","1234","student",msg);
        controller.signUp("Ayush","7463890034","1234","student",msg);
        controller.signUp("Kriti","9472683541","1234","student",msg);
        controller.signUp("Ujjawal","9110091744","1234","student",msg);

        //for batch-2
        controller.signUp("Manjeet","9142202033","1234","student",msg);
        controller.signUp("Amit","8987211979","1234","student",msg);
        controller.signUp("Rohit","9546468148","1234","student",msg);
        controller.signUp("Aditya","9525588208","1234","student",msg);
        controller.signUp("Kishan","9576219441","1234","student",msg);

        //for batch-3
        controller.signUp("Rahul","8809208891","1234","student",msg);
        controller.signUp("Prince","1234567890","1234","student",msg);
        controller.signUp("Ritik","7644844528","1234","student",msg);
        controller.signUp("Aman","7493991930","1234","student",msg);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("\n\n***************************************************");
        System.out.println("*              Welcome To Coding Age              *");
        System.out.println("***************************************************");

        while(true) {
            System.out.println("\n***************");
            System.out.println("*  HOME PAGE  *");
            System.out.println("***************\n");

            System.out.println("Options:");
            System.out.println("1. SignIn");
            System.out.println("2. SignUp");
            System.out.println("3. Exit\n");

            System.out.print("Enter your option: ");
            int opt=0;

                try {
                    opt = sc.nextInt();
                }
                catch (InputMismatchException e) {
                    System.out.print("");
                }

            sc.nextLine();                           // To remove new Line character from input stream.

            switch (opt){
                case 1: signIn();break;
                case 2: signUp();break;
                case 3: return;
                default:
                    System.out.println("Invalid option!");
                    System.out.print("press Enter to go to home page : ");
                    sc.nextLine();
            }
        }
    }    //completed

    static void signUp(){
        Scanner sc=new Scanner(System.in);

        System.out.println("\n****************");
        System.out.println("* SIGN UP PAGE *");
        System.out.println("****************");


        System.out.print("sign up as admin (Y/N): ");
        String opt=sc.nextLine();
        String role;

        if(opt.equalsIgnoreCase("y"))
            role="admin";
        else if(opt.equalsIgnoreCase("n"))
            role="student";
        else {
            System.out.println("Invalid Input!  redirecting to HOME PAGE--> .");
            return;
        }

        System.out.print("Enter Name: ");
        String name= helper.formatName(sc.nextLine());
        if(name.equalsIgnoreCase("q"))                  //Aborts the current process and back to previous menu.
            return;


        while(!helper.isNameValid(name,msg)){
            System.out.print(msg.message+"\nPlease Enter a valid name: ");
            name= helper.formatName(sc.nextLine());
            if(name.equalsIgnoreCase("q"))              //Aborts the current process and back to previous menu.
                return;
        }

        System.out.print("Enter Phone Number: ");
        String phoneNumber= helper.formatPhoneNumber(sc.nextLine());
        if(phoneNumber.equalsIgnoreCase("q"))           //Aborts the current process and back to previous menu.
            return;

        while(!helper.isPhoneNumberValid(phoneNumber,msg)){
            System.out.print(msg.message+"\nPlease enter valid phone number: ");
            phoneNumber= helper.formatPhoneNumber(sc.nextLine());
            if(phoneNumber.equalsIgnoreCase("q"))         //Aborts the current process and back to previous menu.
                return;
        }


        System.out.print("Enter your password: ");
        String password=sc.nextLine();
        if(password.equalsIgnoreCase("q"))
            return;
        while(password==""){
            System.out.print("Enter your password: ");
            password=sc.nextLine();
            if(password.equalsIgnoreCase("q"))
                return;
        }

        //Now signUP
            if(controller.signUp(name,phoneNumber,password,role,msg))
                System.out.println("<--------signed Up successfully.Now you can signIn.------->");
            else
                System.out.println(msg.message+" !SignUp failed");

        System.out.print("press Enter to go to home page : ");
        sc.nextLine();

    } //completed

    static void signIn(){
        Scanner sc=new Scanner(System.in);

        System.out.println("\n****************");
        System.out.println("* SIGN IN PAGE *");
        System.out.println("****************\n");


/*          System.out.print("sign in as admin (Y/N): ");
            String opt=sc.nextLine();
            String role;

            if(opt.equalsIgnoreCase("y"))
                role="admin";
            else if(opt.equalsIgnoreCase("n"))
                role="student";
            else {
                System.out.println("Invalid Input!  redirecting to HOME PAGE--> .");
                return;
            }                                       */

            //phone number
            System.out.print("Enter Phone Number: ");
            String phoneNumber= helper.formatPhoneNumber(sc.nextLine());
            if(phoneNumber.equalsIgnoreCase("q")) //Aborts the current process and back to previous menu.
                return;

            while(!helper.isPhoneNumberValid(phoneNumber,msg)){
                System.out.print(msg.message + "\nPlease Enter valid Phone number: ");
                phoneNumber= helper.formatPhoneNumber(sc.nextLine());
                if(phoneNumber.equalsIgnoreCase("q")) //Aborts the current process and back to previous menu.
                    return;
            }

            //password
            System.out.print("Enter your password: ");
            String password=sc.nextLine();
            if(password.equalsIgnoreCase("q"))
                return;
            while(password==""){
                System.out.print("Enter your password: ");
                password=sc.nextLine();
                if(password.equalsIgnoreCase("q"))
                    return;
            }


/*            if(controller.signIn(phoneNumber,password,role,msg)){
                System.out.println("<--------sign in success------->");

                if (role.equalsIgnoreCase("admin")) {
                    adminHomePage();
                } else {
                    studentHomePage(phoneNumber);
                }
            }
            else
                System.out.println(msg.message+  "\nRedirecting to Home Page----->");    */

            if(controller.adminSignIn(phoneNumber,password,msg)){
                System.out.println("<--------sign in success------->");
                System.out.println("press enter to continue ");
                sc.nextLine();
                adminHomePage();;
            }
            else if(controller.studentSignIn(phoneNumber,password,msg)){
                System.out.println("<--------sign in success------->");
                System.out.println("press enter to continue ");
                sc.nextLine();
                studentHomePage(phoneNumber);
            }
            else
                System.out.println(msg.message+  "\nRedirecting to Home Page----->");

    } //completed

    static void adminHomePage(){
        Scanner sc=new Scanner(System.in);
        do {
            System.out.println("\n*******************");
            System.out.println("* Admin Home Page *");
            System.out.println("*******************\n");
            System.out.println("If you want to return to previous menu ....please enter 'q' ");
            System.out.println("Options:");
            System.out.println("1.Create a batch\n2.Show batchList");
            System.out.println("3.Show studentList ");
            System.out.println("4.Assign a batch to a student\n5.Show student of a particular batch ");
            System.out.println("6.Delete a batch ");
            System.out.println("7.Show feedback Template");
            System.out.println("8.Add question to a batch feedback ");
            System.out.println("9.Edit question of feedback of a batch");
            System.out.println("10.Delete a feedback question of a batch ");
            System.out.println("11.Show feedbacks of a student");
            System.out.println("12.show feedbacks of a batch");
            System.out.println("13.sign out");
            System.out.print("\nEnter you option: ");

            int opt = 0;

            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("");
            }
            sc.nextLine();

            switch (opt) {
                case 1:
                    createBatch();
                    break;
                case 2:
                    showBatchList();
                    break;
                case 3:
                    showStudentList();
                    break;
                case 4:
                    assignBatch();
                    break;
                case 5:
                    getStudentByBatchName();
                    break;
                case 6:
                    setBatchStatus();
                    break;
                case 7:
                    showFeedbackTemplate();
                    break;
                case 8:
                    addQuestion();
                    break;

                case 9:
                    editQuestion();
                    break;
                case 10:
                    deleteQuestion();
                    break;
                case 11:
                    showStudentFeedback();
                    break;
                case 12:
                    showBatchFeedback();
                    break;
                case 13:
                    return;
                default:
                    System.out.println("Invalid option!");
                    System.out.print("press Enter to try again : ");
                    sc.nextLine();
            }
        }while (true);
    }

    static  void studentHomePage(String studentPhoneNumber) {  //currently working
        Scanner sc = new Scanner(System.in);
        Student student = controller.fetchStudent(studentPhoneNumber);

        System.out.println("\n*********************");
        System.out.println("* Student Home Page *");
        System.out.println("*********************\n");
        while (true) {
            System.out.println("Options:");
            System.out.println("1. Submit Feedback");
            System.out.println("2. Sign out");

            System.out.print("Enter your option: ");
            int opt = 0;

            try {
                opt = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("");
            }

            sc.nextLine();                           // To remove new Line character from input stream.

            if (opt == 1)
                submitFeedback(student);
            else if (opt == 2)
                return;
            else {
                System.out.println("!!!invalid input!!!");
                System.out.print("press enter: ");
                sc.nextLine();
            }
        }


    }

    //********Admin Functions**********
    
    static void createBatch(){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Batch Name: ");
        String batchName= helper.formatBatchName(sc.nextLine());

        if(batchName.equalsIgnoreCase("q"))                  //Aborts the current process and back to previous menu.
            return;

        while(!helper.isBatchNameValid(batchName,msg)){
            System.out.print(msg.message+"\nPlease Enter a valid name: ");
            batchName= helper.formatBatchName(sc.nextLine());
            if(batchName.equalsIgnoreCase("q"))              //Aborts the current process and back to previous menu.
                return;
        }


        if(controller.createBatch(batchName,msg))
            System.out.println("batch Created successfully");
        else
            System.out.println(msg.message+"  Batch creation failed!!!!!");

        System.out.print("press Enter to continue");
        sc.nextLine();
    }//completed
    static void assignBatch(){
        Scanner sc=new Scanner(System.in);
        //phone Number section
        String studentPhoneNumber;
        do {

            System.out.print("Enter Student phone Number: ");
            studentPhoneNumber = helper.formatPhoneNumber(sc.nextLine());
            if (studentPhoneNumber.equalsIgnoreCase("q"))           //Aborts the current process and back to previous menu.
                return;

            while (!helper.isPhoneNumberValid(studentPhoneNumber, msg)) {
                System.out.print(msg.message + "\nPlease enter valid phone number: ");
                studentPhoneNumber = helper.formatPhoneNumber(sc.nextLine());
                if (studentPhoneNumber.equalsIgnoreCase("q"))         //Aborts the current process and back to previous menu.
                    return;
            }

            if(!controller.isStudent(studentPhoneNumber)){
                System.out.println("!!!No such student found!!!");
                System.out.print("Enter s to show student list | q to return to homepage | enter anything to try again: ");
                String opt=sc.nextLine();
                if(opt.equalsIgnoreCase("s"))
                    showStudentList();
                else if(opt.equalsIgnoreCase("q"))
                    return;
            }

        }while(!controller.isStudent(studentPhoneNumber));

        //Batch name section
        String batchName;
        System.out.println("Available batches: ");
        showBatchList();
        do {
            System.out.print("Enter Batch name to be assigned: ");
            batchName = helper.formatBatchName(sc.nextLine());
            if (batchName.equalsIgnoreCase("q"))
                return;

            while (!helper.isBatchNameValid(batchName, msg)) {
                System.out.print(msg.message + "\nPlease Enter a valid batchName: ");
                batchName = helper.formatBatchName(sc.nextLine());
                if (batchName.equalsIgnoreCase("q"))
                    return;
            }

            if(!controller.isBatch(batchName)){
                System.out.println("!!!No such batch found!!!");
                System.out.print(("Enter b to show batchList | q to return to homepage | enter anything to try again: "));
                String opt=sc.nextLine();
                if(opt.equalsIgnoreCase("b"))
                    showBatchList();
                else if(opt.equalsIgnoreCase("q"))
                    return;
            }
        }while(!controller.isBatch(batchName));

        if(controller.assignBatch(studentPhoneNumber,batchName,msg))
            System.out.println("batch successfully assigned to student");
        else
            System.out.println(msg.message + " Batch Assign failed!!!!");

        System.out.print("press enter to continue: ");
        sc.nextLine();

    } //completed
    static void setBatchStatus(){
        Scanner sc=new Scanner(System.in);
        //show available batches
        System.out.println("Available batches: ");
        showBatchList();
        //select batch
        String batchName;
        do {
            System.out.print("Enter Batch name to be deleted: ");
            batchName = helper.formatBatchName(sc.nextLine());
            if (batchName.equalsIgnoreCase("q"))
                return;

            while (!helper.isBatchNameValid(batchName, msg)) {
                System.out.print(msg.message + "\nPlease Enter a valid batchName: ");
                batchName = helper.formatBatchName(sc.nextLine());
                if (batchName.equalsIgnoreCase("q"))
                    return;
            }

            if(!controller.isBatch(batchName)){
                System.out.println("!!!No such batch found!!!");
                System.out.print(("Enter b to show batchList | q to return to homepage | enter anything to try again: "));
                String opt=sc.nextLine();
                if(opt.equalsIgnoreCase("b"))
                    showBatchList();
                else if(opt.equalsIgnoreCase("q"))
                    return;
            }
        }while(!controller.isBatch(batchName));


        if(controller.deleteBatch(batchName,msg))
            System.out.println("batch deleted");
        else
            System.out.println(msg.message+"  failed to delete");
        System.out.println("press enter to continue: ");
        sc.nextLine();
    }  //completed
    static void getStudentByBatchName() {
        Scanner sc = new Scanner(System.in);
        //select a batch
        String batchName;
        System.out.println("Available batches: ");
        showBatchList();
        do {
            System.out.print("Enter Batch name : ");
            batchName = helper.formatBatchName(sc.nextLine());
            if (batchName.equalsIgnoreCase("q"))
                return;

            while (!helper.isBatchNameValid(batchName, msg)) {
                System.out.print(msg.message + "\nPlease Enter a valid batchName: ");
                batchName = helper.formatBatchName(sc.nextLine());
                if (batchName.equalsIgnoreCase("q"))
                    return;
            }

            if (!controller.isBatch(batchName)) {
                System.out.println("!!!No such batch found!!!");
                System.out.print(("Enter b to show batchList | q to return to homepage | enter anything to try again: "));
                String opt = sc.nextLine();
                if (opt.equalsIgnoreCase("b"))
                    showBatchList();
                else if (opt.equalsIgnoreCase("q"))
                    return;
            }
        } while (!controller.isBatch(batchName));

        ArrayList<Student> studentList = controller.getStudentByBatchName(batchName, msg);

        if (studentList.isEmpty()) {
            System.out.println("!!!This batch has no students yet!!!");
            System.out.print("press enter to go back : ");
            sc.nextLine();
            return;
        }
        int i = 0;
        for (Student f : studentList) {
            i++;
            System.out.println("\n***Student  :  " + i + "***");
            System.out.println("Student Name : " + f.getName());


            int j = 0;
            for (int k = 0; k < 50; k++) System.out.print("*");
            System.out.println();
        }
        System.out.println("*** Total students : "+i);
        System.out.println("press enter to continue :");
        sc.nextLine();
    }  //to check how student list is showing on cmd
    static void addQuestion(){
        Scanner sc=new Scanner(System.in);
        String batchName;
        System.out.println("Available batches: ");
        showBatchList();

        do {
            System.out.print("Enter Batch name: ");
            batchName = helper.formatBatchName(sc.nextLine());
            if (batchName.equalsIgnoreCase("q"))
                return;

            while (!helper.isBatchNameValid(batchName, msg)) {
                System.out.print(msg.message + "\nPlease Enter a valid batchName: ");
                batchName = helper.formatBatchName(sc.nextLine());
                if (batchName.equalsIgnoreCase("q"))
                    return;
            }

            if(!controller.isBatch(batchName)){
                System.out.println("!!!No such batch found!!!");
                System.out.print(("Enter b to show batchList | q to return to homepage | enter anything to try again: "));
                String opt=sc.nextLine();
                if(opt.equalsIgnoreCase("b"))
                    showBatchList();
                else if(opt.equalsIgnoreCase("q"))
                    return;
            }
        }while(!controller.isBatch(batchName));

        char ch='y';
        do {
            System.out.print("Enter the new Question to be added: ");
            String newQuestion = sc.nextLine();
            if(newQuestion.equalsIgnoreCase("q"))
                return;

            if (controller.addQuestion(batchName, newQuestion, msg)) {
                System.out.println("Question added succesfully");
                System.out.print("Do you want to add more (y/n): ");
                ch=sc.nextLine().charAt(0);
            }
            else
                System.out.println(msg.message + " !!!! failed to add question !!!!");
        }while(ch=='y' || ch=='Y');

    } //completed  //format question should be created
    static void editQuestion(){
        //select batch
        Scanner sc=new Scanner(System.in);
        String batchName;
        System.out.println("Available batches: ");
        showBatchList();
        do {
            System.out.print("Enter Batch name : ");
            batchName = helper.formatBatchName(sc.nextLine());
            if (batchName.equalsIgnoreCase("q"))
                return;

            while (!helper.isBatchNameValid(batchName, msg)) {
                System.out.print(msg.message + "\nPlease Enter a valid batchName: ");
                batchName = helper.formatBatchName(sc.nextLine());
                if (batchName.equalsIgnoreCase("q"))
                    return;
            }

            if(!controller.isBatch(batchName)){
                System.out.println("!!!No such batch found!!!");
                System.out.print(("Enter b to show batchList | q to return to homepage | enter anything to try again: "));
                String opt=sc.nextLine();
                if(opt.equalsIgnoreCase("b"))
                    showBatchList();
                else if(opt.equalsIgnoreCase("q"))
                    return;
            }
        }while(!controller.isBatch(batchName));

        Batch batch= controller.fetchBatch(batchName);

        //show question list of the batch
        System.out.println("\n********Here are question available in the batch feedback**********\n");
        int i=1;
         for(Question question: batch.getFeedbackTemplate().getQuestionList()){
             System.out.println("Q."+i+"  --> "+question.getQuestion());
             i++;
         }
        System.out.println("\nTotal questions = "+ (i-1));

         //select a question number to be edited
        int questionNumber=0;
        do {
            System.out.print("Enter the question number to be edited: ");
            try {
                questionNumber = sc.nextInt();
                sc.nextLine();                      //clears input stream
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input ! Enter a valid integer  question number!!!");
                System.out.print("press Enter to try again OR enter q to return to previous menu: ");
                if(sc.nextLine().equalsIgnoreCase("q"))
                    return;
            }
            if(questionNumber<=0 || questionNumber>i-1)
                System.out.println("!!!Question number out of range!!!");
        }while(questionNumber<=0 || questionNumber>i-1);

        //Enter new Question
        System.out.print("Enter edited question: ");
        String editedQuestion=sc.nextLine();
        if(editedQuestion.equalsIgnoreCase("q"))
            return;

        //update the question
        if(controller.editQuestion(batchName,questionNumber,editedQuestion,msg))
            System.out.println("*****Question Edited successfully*****");
        else{
            System.out.println(msg.message+" !!!!question edit failed!!!!");
        }

    } //completed
    static void deleteQuestion(){
        //select batch
        Scanner sc=new Scanner(System.in);
        String batchName;
        System.out.println("Available batches: ");
        showBatchList();
        do {
            System.out.print("Enter Batch name : ");
            batchName = helper.formatBatchName(sc.nextLine());
            if (batchName.equalsIgnoreCase("q"))
                return;

            while (!helper.isBatchNameValid(batchName, msg)) {
                System.out.print(msg.message + "\nPlease Enter a valid batchName: ");
                batchName = helper.formatBatchName(sc.nextLine());
                if (batchName.equalsIgnoreCase("q"))
                    return;
            }

            if(!controller.isBatch(batchName)){
                System.out.println("!!!No such batch found!!!");
                System.out.print(("Enter b to show batchList | q to return to homepage | enter anything to try again: "));
                String opt=sc.nextLine();
                if(opt.equalsIgnoreCase("b"))
                    showBatchList();
                else if(opt.equalsIgnoreCase("q"))
                    return;
            }
        }while(!controller.isBatch(batchName));

        Batch batch= controller.fetchBatch(batchName);

        //show question list of the batch
        System.out.println("\n********Here are question available in the batch feedback**********\n");
        int i=1;
        for(Question question: batch.getFeedbackTemplate().getQuestionList()){
            System.out.println("Q."+i+"  --> "+question.getQuestion());
            i++;
        }
        System.out.println("\nTotal questions = "+ (i-1));

        //select a question number to be deleted
        int questionNumber=0;
        do {
            System.out.print("Enter the question number to be deleted: ");
            try {
                questionNumber = sc.nextInt();
                sc.nextLine();                                                      //clears input stream
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input ! Enter a valid integer  question number!!!");
                System.out.print("press Enter to try again OR enter q to return to previous menu: ");
                if(sc.nextLine().equalsIgnoreCase("q"))
                    return;
            }

            if(questionNumber<=0 || questionNumber>i-1)
                System.out.println("!!!Question number out of range!!!");
        }while(questionNumber<=0 || questionNumber>i-1);

        if(controller.deleteQuestion(batchName,questionNumber,msg))
            System.out.println("****Question deleted successfully****");
        else
            System.out.println(msg.message+" Question deletion failed!!!");
        System.out.print("press enter to continue: ");
        sc.nextLine();
    } //completed
    static void showStudentFeedback(){
        Scanner sc=new Scanner(System.in);
        //select a student
        String studentPhoneNumber;
        do {

            System.out.print("Enter Student phone Number: ");
            studentPhoneNumber = helper.formatPhoneNumber(sc.nextLine());
            if (studentPhoneNumber.equalsIgnoreCase("q"))           //Aborts the current process and back to previous menu.
                return;

            while (!helper.isPhoneNumberValid(studentPhoneNumber, msg)) {
                System.out.print(msg.message + "\nPlease enter valid phone number: ");
                studentPhoneNumber = helper.formatPhoneNumber(sc.nextLine());
                if (studentPhoneNumber.equalsIgnoreCase("q"))         //Aborts the current process and back to previous menu.
                    return;
            }

            if(!controller.isStudent(studentPhoneNumber)){
                System.out.println("!!!No such student found!!!");
                System.out.print("Enter s to show student list | q to return to homepage | enter anything to try again: ");
                String opt=sc.nextLine();
                if(opt.equalsIgnoreCase("s"))
                    showStudentList();
                else if(opt.equalsIgnoreCase("q"))
                    return;
            }

        }while(!controller.isStudent(studentPhoneNumber));

        ArrayList<Feedback> studentFeedbackList= controller.getStudentFeedback(studentPhoneNumber);
        if(studentFeedbackList.isEmpty()){
            System.out.println("**NO FEEDBACKS Submitted by the student**");
            System.out.print("press enter to continue: ");
            sc.nextLine();
            return;
        }
        //Printing Feedbacks of Student
        int i=0;
        for(Feedback f: studentFeedbackList){
            i++;
            System.out.println("\n***Feedback "+i+"***");
            System.out.println("date: "+f.getDate()+"\n");

            int j=0;
            for(int k=0;k<100;k++) System.out.print("*");
            System.out.println();
            for(Question q: f.getQuestionList()){
                j++;
//                System.out.println("Q."+j+" :- "+q.getQuestion());
//                System.out.println("Ans -> "+q.getAnswer()+"\n");
                System.out.printf("* Q.%d :- %-90s*\n",j,q.getQuestion());
                System.out.printf("* Ans -> %-90s*\n",q.getAnswer());
                System.out.printf("* %96s *\n"," ");
            }
            for(int k=0;k<100;k++) System.out.print("*");
            System.out.println();
        }
        System.out.println("Total Feedbacks submitted: "+i);

        System.out.print("press enter to go back: ");
        sc.nextLine();
    } //completed
    static void showBatchFeedback(){
        Scanner sc=new Scanner(System.in);
        //select a batch
        String batchName;
        System.out.println("Available batches: ");
        showBatchList();
        do {
            System.out.print("Enter Batch name : ");
            batchName = helper.formatBatchName(sc.nextLine());
            if (batchName.equalsIgnoreCase("q"))
                return;

            while (!helper.isBatchNameValid(batchName, msg)) {
                System.out.print(msg.message + "\nPlease Enter a valid batchName: ");
                batchName = helper.formatBatchName(sc.nextLine());
                if (batchName.equalsIgnoreCase("q"))
                    return;
            }

            if(!controller.isBatch(batchName)){
                System.out.println("!!!No such batch found!!!");
                System.out.print(("Enter b to show batchList | q to return to homepage | enter anything to try again: "));
                String opt=sc.nextLine();
                if(opt.equalsIgnoreCase("b"))
                    showBatchList();
                else if(opt.equalsIgnoreCase("q"))
                    return;
            }
        }while(!controller.isBatch(batchName));

        //fetch batch feedbacks
        ArrayList<Feedback> batchFeedbackList= controller.getBatchFeedbackList(batchName);
        if(batchFeedbackList.isEmpty()){
            System.out.println("!!!This batch has no feedbacks yet!!!");
            System.out.print("press enter to go back : ");
            sc.nextLine();
            return;
        }

        //print batch feedbacks
        int i=0;
        for(Feedback f: batchFeedbackList){
            i++;
            System.out.println("\n***Feedback "+i+"***");
            System.out.println("submited by: "+f.getStudentName());
            System.out.println("date: "+f.getDate()+"\n");

            int j=0;
            for(int k=0;k<100;k++) System.out.print("*");
            System.out.println();
            for(Question q: f.getQuestionList()){
                j++;
//                System.out.println("Q."+j+" :- "+q.getQuestion());
//                System.out.println("Ans -> "+q.getAnswer()+"\n");
                System.out.printf("* Q.%d :- %-90s*\n",j,q.getQuestion());
                System.out.printf("* Ans -> %-90s*\n",q.getAnswer());
                System.out.printf("* %96s *\n"," ");
            }
            for(int k=0;k<100;k++) System.out.print("*");
            System.out.println();
        }
        System.out.println("Total Feedbacks ="+ i);

        System.out.print("press enter to go back: ");
        sc.nextLine();
    } //completed
    //*********Student Functions***********
    static void submitFeedback(Student student){
        Scanner sc=new Scanner(System.in);
        //check student is assigned to a batch
        if(student.getBatchName()=="") {
            System.out.println("You are not assigned to any batch. In order to submit feedback you must be assigned to a batch.");
            System.out.print("press enter to continue: ");
            sc.nextLine();
            return;
        }
        //fetch batch feedbackTemplate
        Feedback feedbackTemplate= controller.getBatchFeedbackTemplate(student.getBatchName());
        if(feedbackTemplate==null){
            System.out.println("!!!You are not assigned to any batch!!!");
            return;
        }
        //clone feedbackTemplate
        Feedback studentFeedback=new Feedback(feedbackTemplate,student.getPhoneNumber(),student.getName());
        //Input Answer
        System.out.println("Date: "+LocalDate.now()+"\n");

        for(Question question: studentFeedback.getQuestionList()){

            System.out.println("Question: "+question.getQuestion());

            System.out.print("Answer: ");
            String ans=sc.nextLine();

            if(ans.equalsIgnoreCase("q"))
                return;

            question.setAnswer(ans);
            System.out.println();
        }
        //submit feedback
        if(controller.submitFeedback(studentFeedback,student.getBatchName()))
            System.out.println("Feedback Submitted");
        else
            System.out.println("unexpected error during feedback submission!!!!!!!!!");

        System.out.print("press enter to continue: ");
        sc.nextLine();
    }

    //*********Some useful functions***********

    static void showStudentList(){
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> studentList= controller.getStudentList();
        if(studentList==null){
            System.out.println("!!!No students found!!!");
            return;
        }

//        Formatter fmt=new Formatter();
//        fmt.format("%20s %13s %10s","Student Name","Phone Number","Batch");
        System.out.printf("%-20s %-13s %-10s \n\n","Student Name","Phone Number","Batch");
        int i=0;
        for(Student s: studentList){
            System.out.printf("%-20s %-13s %-10s \n",s.getName(),s.getPhoneNumber(),s.getBatchName());
            i++;
        }
        System.out.println("Total Students="+i);
        System.out.print("press enter to continue: ");
        sc.nextLine();
    } //completed
    static void showBatchList(){
        Scanner sc=new Scanner(System.in);
        ArrayList<Batch> batchList= controller.getBatchList();

        //tabular format printing
//        Formatter fmt=new Formatter();
//        fmt.format("%15s  %13s ","Batch Name","student count");
        System.out.printf("\n%-15s  %-13s      %-12s      %-10s\n\n","Batch Name","student count","Date created","Status");
        for(Batch x: batchList) {
            System.out.printf("%-15s  %-13s      %-12s      %-10s\n", x.getBatchName(), x.getStudentList().size(),x.getDateCreated(),x.isActive()?"Active":"Inactive");
        }
        System.out.println("\nTotal batch = "+batchList.size());
        System.out.print("press enter to continue : ");
        sc.nextLine();
    }//completed
    static void showFeedbackTemplate(){
        Scanner sc=new Scanner(System.in);
        //select a batch
        String batchName;
        System.out.println("Available batches: ");
        showBatchList();
        do {
            System.out.print("Enter Batch name : ");
            batchName = helper.formatBatchName(sc.nextLine());
            if (batchName.equalsIgnoreCase("q"))
                return;

            while (!helper.isBatchNameValid(batchName, msg)) {
                System.out.print(msg.message + "\nPlease Enter a valid batchName: ");
                batchName = helper.formatBatchName(sc.nextLine());
                if (batchName.equalsIgnoreCase("q"))
                    return;
            }

            if(!controller.isBatch(batchName)){
                System.out.println("!!!No such batch found!!!");
                System.out.print(("Enter b to show batchList | q to return to homepage | enter anything to try again: "));
                String opt=sc.nextLine();
                if(opt.equalsIgnoreCase("b"))
                    showBatchList();
                else if(opt.equalsIgnoreCase("q"))
                    return;
            }
        }while(!controller.isBatch(batchName));
        //fetch batch feedbackTemplate
        Feedback batchFeedbackTemplate= controller.getBatchFeedbackTemplate(batchName);
        //show question list of the batch
        System.out.println("\n********Here are question available in the batch feedback**********\n");
        int i=1;
        for(Question question: batchFeedbackTemplate.getQuestionList()){
            System.out.println("Q."+i+"  --> "+question.getQuestion());
            i++;
        }
        System.out.println("\nTotal questions = "+ (i-1));
        System.out.print("press Enter to continue: ");
        sc.nextLine();
    }
}
