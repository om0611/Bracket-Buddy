package com.example.csc207courseproject.use_case.login;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.csc207courseproject.data_access.APIDataAccessObject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * The Login Interactor
 */
public class LoginInteractor implements LoginInputBoundary, PropertyChangeListener {
    private final LoginDataAccessInterface loginDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginDataAccessInterface loginDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.loginDataAccessObject = loginDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;

        loginDataAccessObject.addListener(this);
    }

    @Override
    public void execute(AppCompatActivity activity) {
        try {
            loginDataAccessObject.getAuthCode(activity);
        }
        catch(RuntimeException e) {
            loginPresenter.prepareFailView();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String token;
        try {
            token = loginDataAccessObject.getToken();
            if (token == null) {
                loginPresenter.prepareFailView();
            }
            APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
            apiDataAccessObject.setTOKEN(token);
            loginPresenter.prepareSuccessView();
        }
        catch (InterruptedException e) {
            loginPresenter.prepareFailView();
        }
        loginDataAccessObject.stopServer();
    }
}
