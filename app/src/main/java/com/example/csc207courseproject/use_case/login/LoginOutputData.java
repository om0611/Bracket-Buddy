package com.example.csc207courseproject.use_case.login;

import java.util.List;
import java.util.Map;

/**
 * Output Data for the Login Use Case.
 */
public class LoginOutputData {

    private final Map<Integer, String> tournaments;

    public LoginOutputData(Map<Integer, String> tournaments) {
        this.tournaments = tournaments;
    }

    public Map<Integer, String> getTournaments() {
        return tournaments;
    }
}
