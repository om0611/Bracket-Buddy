package interface_adapter.login;

import interface_adapter.ViewModel;

public class LoginViewModel extends ViewModel<LoginState> {

    public static final String TITLE_LABEL = "Start.gg TO Login";
    public static final String LOGIN_BUTTON_LABEL = "Log in";

    public LoginViewModel() {
        super("log in");
        setState(new LoginState());
    }

}
