package repository;

import model.Admin;

import java.util.ArrayList;

public interface AdminRepository {
    ArrayList<Admin> adminList=new ArrayList<>();

    boolean save(Admin admin);

    boolean isAdmin(String phoneNumber);

    Admin findAdminByPhoneNumber(String phoneNumber);
}
