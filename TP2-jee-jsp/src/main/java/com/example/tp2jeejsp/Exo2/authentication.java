package com.example.tp2jeejsp.Exo2;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

public class authentication implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private Properties validCredentials;

    public authentication() {
        loadCredentials();
    }

    private void loadCredentials() {
        validCredentials = new Properties();
        try {
            // Load from classpath
            InputStream input = getClass().getClassLoader()
                                          .getResourceAsStream("authentication.properties");

            if (input != null) {
                validCredentials.load(input);
                input.close();
            } else {
                System.err.println("Unable to find authentication.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean authenticate() {
        if (username == null || password == null) {
            return false;
        }

        String validPassword = validCredentials.getProperty(username);

        if (validPassword != null && validPassword.equals(password)) {
            return true;
        }

        return false;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
