package uiclient;

import java.util.Objects;

public class Helper {

 // ***********************Validation Functions**********************************

    boolean isPhoneNumberValid(String phoneNumber, Message msg){
        //to check null input
        if(phoneNumber==null || phoneNumber.isEmpty()){
            msg.message="NO input detected!!";
            return false;
        }
        //check length
        if(phoneNumber.length()!=10){       //to check if 10 characters are available
            msg.message="Enter a valid 10 digits phone number";
            return false;
        }

        //check valid characters
        String validDigits="0123456789";

        for(int i=0;i<10;i++){               //to check if all the characters are digit
            char ch=phoneNumber.charAt(i);
            byte f=0;
            for(int j=0;j<10;j++){
                if(ch==validDigits.charAt(j)) {
                    f=1;break;
                }
            }
            if(f==0){
                msg.message="Enter digits only";
                return false;
            }
        }

        return true;
    }

    boolean isNameValid(String name,Message msg){
        //to check null input
        if(name==null || name.isEmpty()){
            msg.message="NO input detected";
            return false;
        }


        String validCharacters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        //loop to check all character are either alphabet or space.
        for(int i=0;i<name.length();i++){
            char ch=name.charAt(i);
            byte f=0;
            for(int j=0;j<validCharacters.length();j++){
                if(ch==validCharacters.charAt(j)){
                    f=1;break;
                }
            }
            if(f==0){
                msg.message="Only alphabets are allowed!";
                return false;
            }
        }

        return true;
    }

    boolean isBatchNameValid(String batchName,Message msg){
        //Format batch-1
        //for null input check
        if(batchName==null || batchName.isEmpty()){
            msg.message="NO input detected";
            return false;
        }
        //check for valid characters
        String validCharacters="0123456789abcdefghijklmnopqrstuvwxyz";

        for(int i=0;i<batchName.length();i++){
            char ch=batchName.charAt(i);
            int f=0;
            for(int j=0;j<validCharacters.length();j++){
                if(ch==validCharacters.charAt(j)){
                    f=1;
                    break;
                }
            }
            if(f==0){
                msg.message="special characters not allowed in batch name";
                return false;
            }
        }

        return  true;
    }

 // **********************Formatter Functions*************************************
    String formatPhoneNumber(String phoneNumber){
        //check null input
        if(phoneNumber==null || phoneNumber.isEmpty())
            return phoneNumber;
        //remove extra spaces
        phoneNumber=phoneNumber.trim();
        phoneNumber=phoneNumber.replaceAll(" ","");
        return phoneNumber;
    } //completed

    String formatName(String name){
        //check null
        if(name==null || name.isEmpty())
            return name;
        //remove extra spaces
        name=name.trim();
        name=name.replaceAll("\\s+"," ");

        //make first letter of each word capital
        name=name.toLowerCase();
        char ch=(char)(name.charAt(0)-32);
        name= ch + name.substring(1);
        for(int i=0;i<name.length();i++){
            if(name.charAt(i)==' '){
                ch=(char)(name.charAt(i+1) - 32);
                name= name.substring(0,i+1) +ch + name.substring(i+2);
            }
        }

        return name;
    } //completed

    String formatBatchName(String batchName){
        //check null input
        if(batchName==null || batchName.isEmpty())
            return batchName;
        //remove extra spaces
        batchName=batchName.trim();
        batchName=batchName.replaceAll(" ","");
        //convert whole string to lowercase
        batchName=batchName.toLowerCase();

        return batchName;
    }
}
