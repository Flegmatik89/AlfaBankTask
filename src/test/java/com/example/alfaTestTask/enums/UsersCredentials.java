package com.example.alfaTestTask.enums;

import com.example.alfaTestTask.utility.ConfigurationManager;

public enum UsersCredentials {
    LOGIN(ConfigurationManager.getPropertyFromTestDataFile("login")),
    PASS(ConfigurationManager.getPropertyFromTestDataFile("password"));
    private final String credentials;

    UsersCredentials(String credentials) {
        this.credentials = credentials;
    }

    public String getCredential() {
        return credentials;
    }
}
