package viewmodel;

import java.util.List;
import model.User;
import model.Internship;
import repository.UserRepository;
import repository.InternshipRepository;
import utils.ValidationUtils;

public class UserViewModel {
    private final UserRepository userRepository;
    private final InternshipRepository internshipRepository;

    public UserViewModel(UserRepository userRepository, InternshipRepository internshipRepository){
        this.userRepository = userRepository;
        this.internshipRepository = internshipRepository;
    }

    public void registerUser(String name, String email, String password, String skill){
        if(name == null || name.isBlank() || email == null || email.isBlank() || password == null || password.isBlank()){
            System.out.println("All fields are required!");
            return;
        }
        if(!ValidationUtils.isValidEmail(email)){
            System.out.println("Invalid email format!");
            return;
        }
        User u = new User(name.trim(), email.trim(), password, (skill == null ? "" : skill.trim()));
        if(userRepository.addUser(u)){
            System.out.println("User registered successfully!");
        } else {
            System.out.println("User already exists with this email!");
        }
    }

    public boolean login(String email, String password){
        User u = userRepository.getUserByEmail(email);
        if(u == null) return false;
        return u.getPassword().equals(password);
    }

    public User getProfile(String email){
        return userRepository.getUserByEmail(email);
    }

    public List<Internship> searchInternships(){
        return internshipRepository.getApprovedInternships();
    }
}
