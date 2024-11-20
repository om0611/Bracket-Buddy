package use_case.login;

import data_access.APIDataAccessObject;

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
    public void execute() {
        String token = "";
        try {
            token = loginDataAccessObject.login();
            APIDataAccessObject apiDataAccessObject = new APIDataAccessObject();
            apiDataAccessObject.setTOKEN(token);
            System.out.println(apiDataAccessObject.getTournaments());   // Temporary
            loginPresenter.prepareSuccessView();
        }
        catch(Exception e) {
            loginPresenter.prepareFailView("Failed to login!");
        }
    }
}
