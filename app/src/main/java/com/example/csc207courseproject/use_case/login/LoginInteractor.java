package com.example.csc207courseproject.use_case.login;

import android.content.Context;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.csc207courseproject.data_access.APIDataAccessObject;

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
        String token = "";
        try {
            token = loginDataAccessObject.login(activity);
            APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
            apiDataAccessObject.setTOKEN(token);
//            System.out.println(apiDataAccessObject.getTournaments());
            loginPresenter.prepareSuccessView();
        }
        catch(Exception e) {
            loginPresenter.prepareFailView();
        }
        loginDataAccessObject.stopServer();
    }

}
