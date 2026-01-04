package model;

public class Internship {
    private String title;
    private String description;
    private String employerEmail;

    // Internship-specific fields
    private String duration;        // e.g., "6 weeks", "3 months"
    private String stipend;         // e.g., "Paid 20,000 PKR", "Unpaid"
    private String mode;            // Remote / Onsite / Hybrid
    private String startDate;       // e.g., "2026-02-01"
    private String skillsRequired;  // comma separated
    private String eligibility;     // e.g., "BSCS 5th semester+"

    private boolean approved;

    public Internship(
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
        this.title = title;
        this.description = description;
        this.employerEmail = employerEmail;
        this.duration = duration;
        this.stipend = stipend;
        this.mode = mode;
        this.startDate = startDate;
        this.skillsRequired = skillsRequired;
        this.eligibility = eligibility;
        this.approved = false;
    }

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getEmployerEmail() { return employerEmail; }

    public String getDuration() { return duration; }
    public String getStipend() { return stipend; }
    public String getMode() { return mode; }
    public String getStartDate() { return startDate; }
    public String getSkillsRequired() { return skillsRequired; }
    public String getEligibility() { return eligibility; }

    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}
