package interface_adapter.login;

import use_case.login.LoginInputBoundary;

/**
 * Controller for the Login Use Case.
 */
public class LoginController {

    private final LoginInputBoundary loginInteractor;

    public LoginController(LoginInputBoundary loginInteractor) {
        this.loginInteractor = loginInteractor;
    }

    public void execute() {
        loginInteractor.execute();
    }
}
