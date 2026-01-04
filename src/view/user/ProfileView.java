package view.user;

import model.User;
import viewmodel.UserViewModel;

public class ProfileView {
    private final UserViewModel userViewModel;

    public ProfileView(UserViewModel userViewModel){
        this.userViewModel = userViewModel;
    }

    public void show(String email){
        User u = userViewModel.getProfile(email);
        if(u == null){
            System.out.println("Profile not found!");
            return;
        }
        System.out.println("\n=== User Profile ===");
        System.out.println("Name: " + u.getName());
        System.out.println("Email: " + u.getEmail());
        System.out.println("Skill: " + u.getSkill());
    }
}
