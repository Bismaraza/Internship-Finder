package repository;

import java.util.ArrayList;
import java.util.List;
import model.Internship;

public class InternshipRepository {
    private final List<Internship> internships = new ArrayList<>();

    public void addInternship(Internship internship){
        internships.add(internship);
        System.out.println("Internship submitted for approval: " + internship.getTitle());
    }

    public List<Internship> getAllInternships(){ return internships; }

    public List<Internship> getApprovedInternships(){
        List<Internship> approved = new ArrayList<>();
        for(Internship i : internships){
            if(i.isApproved()) approved.add(i);
        }
        return approved;
    }

    public List<Internship> getPendingInternships(){
        List<Internship> pending = new ArrayList<>();
        for(Internship i : internships){
            if(!i.isApproved()) pending.add(i);
        }
        return pending;
    }

    public void approveInternship(Internship internship){
        internship.setApproved(true);
        System.out.println("Approved: " + internship.getTitle());
    }

    public void removeInternship(Internship internship){
        internships.remove(internship);
        System.out.println("Removed: " + internship.getTitle());
    }

    public List<Internship> getInternshipsByEmployer(String employerEmail){
        List<Internship> mine = new ArrayList<>();
        for(Internship i : internships){
            if(i.getEmployerEmail().equalsIgnoreCase(employerEmail)) mine.add(i);
        }
        return mine;
    }
}
