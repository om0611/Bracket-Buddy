package com.example.csc207courseproject.use_case.login;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/**
 * DAO for the Login Use Case
 */
public interface LoginDataAccessInterface {

    /**
     * Prompts the user to log in to their start.gg account.
     * @return true if the user successfully logged in to start.gg; false otherwise
     */
    boolean login(AppCompatActivity activity);

    /**
     * Stop the HTTP Server
     */
    void stopServer();

    /**
     * Gets a list of tournaments organized by the user.
     * @return a list of tournaments
     */
    List getTournaments();

}
