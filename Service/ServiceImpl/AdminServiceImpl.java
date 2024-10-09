package Service.ServiceImpl;

import model.Admin;
import repository.impl.AdminRepositoryImpl;
import uiclient.Message;
import Service.AdminService;

public class AdminServiceImpl implements AdminService {
    public AdminRepositoryImpl adminRepoimpl = new AdminRepositoryImpl();
    public StudentServiceImpl studentService = StudentServiceImpl.getInstance();

    public boolean signUp(String name, String phoneNumber, String password, Message msg) {
        Admin admin = adminRepoimpl.findAdminByPhoneNumber(phoneNumber);
        boolean isStudent = studentService.isStudent(phoneNumber);
        if (admin != null || isStudent) {
            msg.setMessage("Phone Number already Registered as student or admin ");
            return false;
        } else {
            Admin newAdmin = new Admin(name, phoneNumber, password);
            adminRepoimpl.save(newAdmin);
        }
        return true;
    }

    public boolean signIn(String phoneNumber, String password, Message msg) {
        Admin admin = adminRepoimpl.findAdminByPhoneNumber(phoneNumber);
        boolean isAdmin = adminRepoimpl.isAdmin(phoneNumber);
        if (isAdmin) {
            if (admin != null) {
                if (password.equals(admin.getPassword()))
                    return true;
            } else {
                msg.setMessage("wrong phoneNumber or password");
                return false;

            }
        }
        msg.setMessage("User not found");
        return false;
    }

    public boolean isAdmin(String phoneNumber) {
        boolean isAdmin = adminRepoimpl.isAdmin(phoneNumber);
        if (isAdmin) {
            return true;
        } else {
            return false;
        }
    }
}
