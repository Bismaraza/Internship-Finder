package view.employer;

import java.util.List;
import model.Internship;
import viewmodel.EmployerViewModel;

public class ViewApplicantsView {
    private final EmployerViewModel employerViewModel;

    public ViewApplicantsView(EmployerViewModel employerViewModel){ this.employerViewModel = employerViewModel; }

    public void showInternships(String employerEmail){
        List<Internship> internships = employerViewModel.getMyInternships(employerEmail);
        System.out.println("\n=== Internships Posted by You ===");
        if(internships.isEmpty()){
            System.out.println("No internships posted yet!");
            return;
        }

        int idx = 1;
        for(Internship i : internships){
            System.out.println("\n[" + (idx++) + "] " + i.getTitle() + (i.isApproved() ? " (APPROVED)" : " (PENDING)"));
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
