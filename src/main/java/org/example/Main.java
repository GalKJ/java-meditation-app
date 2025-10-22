package org.example;
import java.util.Scanner;

import org.example.users.Password;
import org.example.users.User;
import org.example.users.Username;
import org.example.services.AuthService;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Meditation App ===");
            System.out.println("1. Sign up");

            if (authService.getLoggedInUser() == null) {
                System.out.println("2. Log in");
            } else {
                System.out.println("2. Log out");
            }

            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Please enter a username:");
                    String signupUsername = scanner.nextLine();
                    System.out.println("Please enter a password:");
                    String signUpPassword = scanner.nextLine();
                    try {
                        User newUser = new User(
                                new Username(signupUsername),
                                new Password(signUpPassword)
                        );

                        if (authService.signUp(newUser)) {
                            System.out.println("User signed up successfully!");
                        } else {
                            System.out.println("This username already exists!");
                        }
                    } catch(IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                }
                    break;
                case "2":
                    if (authService.getLoggedInUser() == null) {
                        System.out.print("Enter username: ");
                        String loginUsername = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String loginPassword = scanner.nextLine();

                        if (authService.logIn(loginUsername, loginPassword)) {
                            System.out.println("Login successful! Welcome " + loginUsername);
                        } else {
                            System.out.println("Login failed. Invalid username or password.");
                        }

                    } else {
                        System.out.println("User " + authService.getLoggedInUser().getUsername().getValue() + " logged out.");
                    }
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
