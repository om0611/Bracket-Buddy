package com.example.csc207courseproject.interface_adapter.login;

import com.example.csc207courseproject.interface_adapter.ViewManagerModel;
import com.example.csc207courseproject.use_case.login.LoginOutputBoundary;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;

    public LoginPresenter(LoginViewModel loginViewModel,
                          ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        loginViewModel.firePropertyChanged("loginsuccess");
    }

    @Override
    public void prepareFailView() {
        loginViewModel.firePropertyChanged("loginfail");
    }
}
