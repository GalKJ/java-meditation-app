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
        if (loggedInUser != null) {
            return false;
        }

        for (User user : users) {
            if (user.getUsername().getValue().equals(username)
                    && user.getPassword().matches(password)) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }

    public String logOut() {
        if (loggedInUser != null) {
            String username = loggedInUser.getUsername().getValue();
            loggedInUser = null;
            return username;
        } else {
            return null;
        }
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
    }

