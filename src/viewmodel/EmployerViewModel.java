package viewmodel;

import java.util.List;
import model.Employer;
import model.Internship;
import repository.EmployerRepository;
import repository.InternshipRepository;
import utils.ValidationUtils;

public class EmployerViewModel {
    private final EmployerRepository employerRepository;
    private final InternshipRepository internshipRepository;

    public EmployerViewModel(EmployerRepository employerRepository, InternshipRepository internshipRepository){
        this.employerRepository = employerRepository;
        this.internshipRepository = internshipRepository;
    }

    public void registerEmployer(String name, String company, String email){
        if(name == null || name.isBlank() || company == null || company.isBlank() || email == null || email.isBlank()){
            System.out.println("All fields are required!");
            return;
        }
        if(!ValidationUtils.isValidEmail(email)){
            System.out.println("Invalid email format!");
            return;
        }
        Employer e = new Employer(name.trim(), company.trim(), email.trim());
        if(employerRepository.addEmployer(e)){
            System.out.println("Employer registered successfully!");
        } else {
            System.out.println("Employer already exists with this email!");
        }
    }

    public void postInternship(
            String title,
            String description,
            String employerEmail,
            String duration,
            String stipend,
            String mode,
            String startDate,
            String skillsRequired,
            String eligibility
    ){
        if(title == null || title.isBlank() || description == null || description.isBlank()){
            System.out.println("Title and description are required!");
            return;
        }
        Internship i = new Internship(
                title.trim(),
                description.trim(),
                employerEmail,
                safe(duration),
                safe(stipend),
                safe(mode),
                safe(startDate),
                safe(skillsRequired),
                safe(eligibility)
        );
        internshipRepository.addInternship(i);
        System.out.println("Your internship is submitted. Admin will approve it soon.");
    }

    private String safe(String s){ return (s == null) ? "" : s.trim(); }

    public Employer getProfile(String email){
        return employerRepository.getEmployerByEmail(email);
    }

    public List<Internship> getMyInternships(String email){
        return internshipRepository.getInternshipsByEmployer(email);
    }
}
