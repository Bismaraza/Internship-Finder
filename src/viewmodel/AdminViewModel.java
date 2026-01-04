package viewmodel;

import java.util.List;
import model.Admin;
import model.Internship;
import repository.AdminRepository;
import repository.InternshipRepository;
import utils.ValidationUtils;

public class AdminViewModel {
    private final AdminRepository adminRepository;
    private final InternshipRepository internshipRepository;

    public AdminViewModel(AdminRepository adminRepository, InternshipRepository internshipRepository){
        this.adminRepository = adminRepository;
        this.internshipRepository = internshipRepository;
    }

    public void addAdmin(String name, String email){
        if(name == null || name.isBlank() || email == null || email.isBlank()){
            System.out.println("Name and email required!");
            return;
        }
        if(!ValidationUtils.isValidEmail(email)){
            System.out.println("Invalid email format!");
            return;
        }
        Admin admin = new Admin(name.trim(), email.trim());
        if(adminRepository.addAdmin(admin)){
            System.out.println("Admin added successfully!");
        } else {
            System.out.println("Admin already exists with this email!");
        }
    }

    public Admin getAdminProfile(String email){
        return adminRepository.getAdminByEmail(email);
    }

    public List<Internship> getPendingInternships(){
        return internshipRepository.getPendingInternships();
    }

    public void approveInternship(Internship internship){
        internshipRepository.approveInternship(internship);
    }

    public void rejectInternship(Internship internship){
        internshipRepository.removeInternship(internship);
    }
}
