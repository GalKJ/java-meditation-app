package org.example.services;

import org.example.users.User;

import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private final List<User> users = new ArrayList<>();
    private User loggedInUser = null;

    public boolean signUp(User newUser) {

        for (User user : users ) {
            if (user.getUsername().getValue().equals(newUser.getUsername().getValue())) {
                return false;
            }
        }

        users.add(newUser);
        return true;

    }

    public boolean logIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().getValue().equals(username)
                    && user.getPassword().matches(password)) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }

    public boolean logOut() {
        if (loggedInUser != null) {
//            System.out.println("User " + loggedInUser.getUsername().getValue() + " logged out.");
            loggedInUser = null;
            return true;
        } else {
            System.out.println("No user is currently logged in.");
            return false;
        }
    }
}
