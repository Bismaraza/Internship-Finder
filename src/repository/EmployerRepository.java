package repository;

import java.util.ArrayList;
import java.util.List;
import model.Employer;

public class EmployerRepository {
    private final List<Employer> employers = new ArrayList<>();

    public boolean addEmployer(Employer employer){
        if(getEmployerByEmail(employer.getEmail()) != null) return false;
        employers.add(employer);
        return true;
    }

    public Employer getEmployerByEmail(String email){
        for(Employer e : employers){
            if(e.getEmail().equalsIgnoreCase(email)) return e;
        }
        return null;
    }

    public List<Employer> getAllEmployers(){ return employers; }
}
