import java.util.List;
import java.util.Scanner;

import model.Internship;
import repository.AdminRepository;
import repository.EmployerRepository;
import repository.InternshipRepository;
import repository.UserRepository;
import view.employer.EmployerProfileView;
import view.employer.PostInternshipView;
import view.employer.ViewApplicantsView;
import view.user.InternshipSearchView;
import view.user.LoginView;
import view.user.ProfileView;
import view.user.RegisterView;
import viewmodel.AdminViewModel;
import viewmodel.EmployerViewModel;
import viewmodel.UserViewModel;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Shared repositories (in-memory)
        InternshipRepository internshipRepository = new InternshipRepository();
        UserRepository userRepository = new UserRepository();
        EmployerRepository employerRepository = new EmployerRepository();
        AdminRepository adminRepository = new AdminRepository();

        // ViewModels
        UserViewModel userViewModel = new UserViewModel(userRepository, internshipRepository);
        EmployerViewModel employerViewModel = new EmployerViewModel(employerRepository, internshipRepository);
        AdminViewModel adminViewModel = new AdminViewModel(adminRepository, internshipRepository);

        // Views
        RegisterView registerView = new RegisterView(userViewModel);
        LoginView loginView = new LoginView(userViewModel);
        ProfileView profileView = new ProfileView(userViewModel);
        InternshipSearchView internshipSearchView = new InternshipSearchView(userViewModel);

        PostInternshipView postInternshipView = new PostInternshipView(employerViewModel);
        ViewApplicantsView viewApplicantsView = new ViewApplicantsView(employerViewModel);
        EmployerProfileView employerProfileView = new EmployerProfileView(employerViewModel);

        String loggedUserEmail = null;
        String loggedEmployerEmail = null;
        String loggedAdminEmail = null;

        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. User Module");
            System.out.println("2. Employer Module");
            System.out.println("3. Admin Module");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a NUMBER!");
                sc.nextLine();
                continue;
            }
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                // ================= USER =================
                case 1 -> {
                    while (true) {
                        System.out.println("\n--- User Module ---");
                        System.out.println("1. Register");
                        System.out.println("2. Login");
                        System.out.println("3. View Profile");
                        System.out.println("4. Search Internships");
                        System.out.println("5. Back");
                        System.out.print("Choose: ");

                        if (!sc.hasNextInt()) {
                            System.out.println("Enter number only!");
                            sc.nextLine();
                            continue;
                        }

                        int uChoice = sc.nextInt();
                        sc.nextLine();

                        switch (uChoice) {
                            case 1 -> registerView.show();
                            case 2 -> {
                                loggedUserEmail = loginView.show();
                            }
                            case 3 -> {
                                if (loggedUserEmail == null) {
                                    System.out.println("Please login first!");
                                } else {
                                    profileView.show(loggedUserEmail);
                                }
                            }
                            case 4 -> internshipSearchView.show();
                            case 5 -> { break; }
                            default -> System.out.println("Invalid choice!");
                        }
                        if (uChoice == 5) break;
                    }
                }

                // ================= EMPLOYER =================
                case 2 -> {
                    while (true) {
                        System.out.println("\n--- Employer Module ---");
                        System.out.println("1. Register Employer");
                        System.out.println("2. Post Internship");
                        System.out.println("3. View Internships Posted");
                        System.out.println("4. View Profile");
                        System.out.println("5. Back");
                        System.out.print("Choose: ");

                        if (!sc.hasNextInt()) {
                            System.out.println("Enter number only!");
                            sc.nextLine();
                            continue;
                        }

                        int eChoice = sc.nextInt();
                        sc.nextLine();

                        switch (eChoice) {
                            case 1 -> {
                                System.out.print("Name: ");
                                String name = sc.nextLine();
                                System.out.print("Company: ");
                                String company = sc.nextLine();
                                System.out.print("Email: ");
                                String email = sc.nextLine();
                                employerViewModel.registerEmployer(name, company, email);
                                loggedEmployerEmail = email;
                            }
                            case 2 -> {
                                if (loggedEmployerEmail == null) {
                                    System.out.println("Please register employer first (Option 1).");
                                } else {
                                    postInternshipView.show(loggedEmployerEmail);
                                }
                            }
                            case 3 -> {
                                if (loggedEmployerEmail == null) {
                                    System.out.println("Please register employer first (Option 1).");
                                } else {
                                    viewApplicantsView.showInternships(loggedEmployerEmail);
                                }
                            }
                            case 4 -> {
                                if (loggedEmployerEmail == null) {
                                    System.out.println("Please register employer first (Option 1).");
                                } else {
                                    employerProfileView.show(loggedEmployerEmail);
                                }
                            }
                            case 5 -> { break; }
                            default -> System.out.println("Invalid choice!");
                        }
                        if (eChoice == 5) break;
                    }
                }

                // ================= ADMIN =================
                case 3 -> {
                    while (true) {
                        System.out.println("\n--- Admin Module ---");
                        System.out.println("1. Add Admin");
                        System.out.println("2. View Pending Internships");
                        System.out.println("3. Approve Internship");
                        System.out.println("4. Reject Internship");
                        System.out.println("5. Back");
                        System.out.print("Choose: ");

                        if (!sc.hasNextInt()) {
                            System.out.println("Enter number only!");
                            sc.nextLine();
                            continue;
                        }

                        int aChoice = sc.nextInt();
                        sc.nextLine();

                        switch (aChoice) {
                            case 1 -> {
                                System.out.print("Admin Name: ");
                                String name = sc.nextLine();
                                System.out.print("Admin Email: ");
                                String email = sc.nextLine();
                                adminViewModel.addAdmin(name, email);
                                loggedAdminEmail = email;
                            }

                            case 2 -> {
                                List<Internship> pending = adminViewModel.getPendingInternships();
                                System.out.println("\n=== Pending Internships ===");
                                if (pending.isEmpty()) {
                                    System.out.println("No pending internships!");
                                } else {
                                    int idx = 1;
                                    for (Internship i : pending) {
                                        System.out.println("\n[" + (idx++) + "] " + i.getTitle());
                                        System.out.println("Employer: " + i.getEmployerEmail());
                                        System.out.println("Description: " + i.getDescription());
                                        System.out.println("Duration: " + i.getDuration());
                                        System.out.println("Stipend: " + i.getStipend());
                                        System.out.println("Mode: " + i.getMode());
                                        System.out.println("Start Date: " + i.getStartDate());
                                        System.out.println("Skills Required: " + i.getSkillsRequired());
                                        System.out.println("Eligibility: " + i.getEligibility());
                                    }
                                }
                            }

                            case 3 -> {
                                List<Internship> pending = adminViewModel.getPendingInternships();
                                if (pending.isEmpty()) {
                                    System.out.println("No pending internships!");
                                    break;
                                }
                                System.out.print("Enter internship number to APPROVE: ");
                                if (sc.hasNextInt()) {
                                    int num = sc.nextInt();
                                    sc.nextLine();
                                    if (num > 0 && num <= pending.size()) {
                                        adminViewModel.approveInternship(pending.get(num - 1));
                                    } else {
                                        System.out.println("Invalid number!");
                                    }
                                } else {
                                    System.out.println("Please enter NUMBER only!");
                                    sc.nextLine();
                                }
                            }

                            case 4 -> {
                                List<Internship> pending = adminViewModel.getPendingInternships();
                                if (pending.isEmpty()) {
                                    System.out.println("No pending internships!");
                                    break;
                                }
                                System.out.print("Enter internship number to REJECT: ");
                                if (sc.hasNextInt()) {
                                    int num = sc.nextInt();
                                    sc.nextLine();
                                    if (num > 0 && num <= pending.size()) {
                                        adminViewModel.rejectInternship(pending.get(num - 1));
                                    } else {
                                        System.out.println("Invalid number!");
                                    }
                                } else {
                                    System.out.println("Please enter NUMBER only!");
                                    sc.nextLine();
                                }
                            }

                            case 5 -> { break; }
                            default -> System.out.println("Invalid choice!");
                        }
                        if (aChoice == 5) break;
                    }
                }

                case 4 -> {
                    System.out.println("Exiting System...");
                    return;
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
