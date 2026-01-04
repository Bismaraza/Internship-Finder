package view.user;

import java.util.List;
import model.Internship;
import viewmodel.UserViewModel;

public class InternshipSearchView {
    private final UserViewModel userViewModel;

    public InternshipSearchView(UserViewModel userViewModel){ this.userViewModel = userViewModel; }

    public void show(){
        List<Internship> internships = userViewModel.searchInternships();
        System.out.println("\n=== Approved Internships ===");
        if(internships.isEmpty()){
            System.out.println("No internships available right now!");
            return;
        }

        int idx = 1;
        for(Internship i : internships){
            System.out.println("\n[" + (idx++) + "] " + i.getTitle());
            System.out.println("Company Email: " + i.getEmployerEmail());
            System.out.println("Description: " + i.getDescription());
            System.out.println("Duration: " + i.getDuration());
            System.out.println("Stipend: " + i.getStipend());
            System.out.println("Mode: " + i.getMode());
            System.out.println("Start Date: " + i.getStartDate());
            System.out.println("Skills Required: " + i.getSkillsRequired());
            System.out.println("Eligibility: " + i.getEligibility());
        }
    }
}
