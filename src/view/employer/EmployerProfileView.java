package view.employer;

import model.Employer;
import viewmodel.EmployerViewModel;

public class EmployerProfileView {
    private final EmployerViewModel employerViewModel;

    public EmployerProfileView(EmployerViewModel employerViewModel){ this.employerViewModel = employerViewModel; }

    public void show(String email){
        Employer e = employerViewModel.getProfile(email);
        if(e != null){
            System.out.println("\n=== Employer Profile ===");
            System.out.println("Name: " + e.getName());
            System.out.println("Company: " + e.getCompany());
            System.out.println("Email: " + e.getEmail());
        } else {
            System.out.println("Profile not found!");
        }
    }
}
