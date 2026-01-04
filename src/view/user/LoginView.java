package view.user;

import java.util.Scanner;
import viewmodel.UserViewModel;

public class LoginView {
    private final UserViewModel userViewModel;
    private final Scanner sc = new Scanner(System.in);

    public LoginView(UserViewModel userViewModel){
        this.userViewModel = userViewModel;
    }

    public String show(){
        System.out.println("\n=== User Login ===");
        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("Password: ");
        String pass = sc.nextLine();

        boolean ok = userViewModel.login(email, pass);
        if(ok){
            System.out.println("Login successful!");
            return email;
        } else {
            System.out.println("Invalid credentials!");
            return null;
        }
    }
}
