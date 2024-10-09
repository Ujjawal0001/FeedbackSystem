package Service;

import Service.ServiceImpl.StudentServiceImpl;
import uiclient.Message;

public interface AdminService {
    boolean signUp(String name , String phoneNumber , String password ,  Message msg);
    boolean signIn(String phoneNumber , String password , Message msg);
    boolean isAdmin(String phoneNumber);
}
