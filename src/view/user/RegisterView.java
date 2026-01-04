package view.user;

import java.util.Scanner;
import viewmodel.UserViewModel;

public class RegisterView {
    private final UserViewModel userViewModel;
    private final Scanner sc = new Scanner(System.in);

    public RegisterView(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
    }

    public void show() {
        System.out.println("\n=== User Registration ===");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        System.out.print("Skill (e.g., Java, React, Excel): ");
        String skill = sc.nextLine();

        userViewModel.registerUser(name, email, pass, skill);
    }
}
