# How To Use Section

 1.  In any point of the program enter 'q' to abort the current process and return to previous menu.
        except:   1. During entering question number.
                  2. when a message like "press enter to continue" shows.
                  3. when entering your options.




# Code layout Section
    1. Model
        a. student

            //attributes
                name
                phoneNumber
                password
                batchName
                studentInBatch  ---> stores boolean value which indicates wether the student is assigned to a batch or not.
                feedbackList    ---> list of feedbacks submited by the student.

            //constructor       ---> contruct using name,phoneNumber and password.
            //getter setters
            //behavior
                void addFeedback(Feedback feedback)     ---> adds the feedback submited by the student to feedbackList.
                
        b. admin

            //attributes
                name
                phoneNumber
                password
            
            //constructor   ---> construct using name,phoneNumber and password.

            //getter setters

        c. batch

            //attributes
                batchName
                dateCreated
                Feedback feedbackTemplate   ---> contains questions to be asked during feedback submission.
                studentList
                feedbackList
                isActive

            //constructor
                Batch(String batchName)     ---> Initializes batchName,dateCreated and isActive .

            //getter setters
            //behaviors
                void addStudent(Student student)        ---> Adds the student to studentList.
                void addFeedback(Feedback feedback)     ---> Adds the feedback submitted by student to feedbackList.

        d. feedback

            //attributes
                
        e. question

    2. Controller
    3. Service
    4. Repository
    5. Uiclient
        