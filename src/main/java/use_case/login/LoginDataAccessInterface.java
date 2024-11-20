package use_case.login;

/**
 * DAO for the Login Use Case
 */
public interface LoginDataAccessInterface {
    /**
     * Prompts the user to log in to their start.gg account.
     * @return the user's API token if the user successfully logged in to start.gg
     */
    String login();
}
