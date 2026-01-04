package repository;

import java.util.ArrayList;
import java.util.List;
import model.Admin;

public class AdminRepository {
    private final List<Admin> admins = new ArrayList<>();

    public boolean addAdmin(Admin admin){
        if(getAdminByEmail(admin.getEmail()) != null) return false;
        admins.add(admin);
        return true;
    }

    public Admin getAdminByEmail(String email){
        for(Admin a : admins){
            if(a.getEmail().equalsIgnoreCase(email)) return a;
        }
        return null;
    }

    public List<Admin> getAllAdmins(){ return admins; }
}
