package com.example.csc207courseproject.use_case.login;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

/**
 * The Login Interactor
 */
public class LoginInteractor implements LoginInputBoundary {
    private final LoginDataAccessInterface loginDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginDataAccessInterface loginDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.loginDataAccessObject = loginDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(AppCompatActivity activity) {
        if (loginDataAccessObject.login(activity)) {
            Log.d("breakpoint", "Hi!");
//            List tournaments = loginDataAccessObject.getTournaments();
//            System.out.println(tournaments);        // temporary
            loginPresenter.prepareSuccessView();
        }
        else {
            loginPresenter.prepareFailView();
            Log.d("breakpoint", "Hello!");
        }
        loginDataAccessObject.stopServer();
    }

}
