package view.employer;

import java.util.Scanner;
import viewmodel.EmployerViewModel;

public class PostInternshipView {
    private final EmployerViewModel employerViewModel;
    private final Scanner sc = new Scanner(System.in);

    public PostInternshipView(EmployerViewModel employerViewModel){ this.employerViewModel = employerViewModel; }

    public void show(String employerEmail){
        System.out.println("\n=== Post an Internship ===");

        System.out.print("Internship Title: ");
        String title = sc.nextLine();

        System.out.print("Internship Description: ");
        String desc = sc.nextLine();

        System.out.print("Duration (e.g., 6 weeks / 3 months): ");
        String duration = sc.nextLine();

        System.out.print("Stipend (e.g., Paid 20000 PKR / Unpaid): ");
        String stipend = sc.nextLine();

        System.out.print("Mode (Remote / Onsite / Hybrid): ");
        String mode = sc.nextLine();

        System.out.print("Start Date (e.g., 2026-02-01): ");
        String startDate = sc.nextLine();

        System.out.print("Skills Required (comma separated): ");
        String skills = sc.nextLine();

        System.out.print("Eligibility (e.g., BSCS 5th semester+): ");
        String eligibility = sc.nextLine();

        employerViewModel.postInternship(title, desc, employerEmail, duration, stipend, mode, startDate, skills, eligibility);
    }
}
