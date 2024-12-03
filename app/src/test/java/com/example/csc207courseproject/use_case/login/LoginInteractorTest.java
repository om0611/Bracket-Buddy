package com.example.csc207courseproject.use_case.login;

import com.example.csc207courseproject.data_access.OAuth.OAuthDataAccessObject;
import com.example.csc207courseproject.data_access.OAuth.OAuthException;
import com.example.csc207courseproject.data_access.api.APIDataAccessObject;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class LoginInteractorTest {

    @Test
    void getAuthUrlFailTest() {

        // Create new getAuthUrl method that throws an exception for this test
        LoginOAuthDataAccessInterface loginOAuthDataAccessInterface = new OAuthDataAccessObject() {
            @Override
            public String getAuthUrl() {
                throw new OAuthException("The server failed to start.");
            }
        };

        // Check if the prepareFailView is called by the interactor
        LoginOutputBoundary failPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData loginOutputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        LoginDataAccessInterface loginDataAccessInterface = new APIDataAccessObject();

        LoginInputBoundary interactor = new LoginInteractor(loginOAuthDataAccessInterface, failPresenter,
                loginDataAccessInterface);
        interactor.execute();
    }

    @Test
    void getAuthUrlSuccessTest() {

        // Create new getAuthUrl method that returns "success"
        LoginOAuthDataAccessInterface loginOAuthDataAccessInterface = new OAuthDataAccessObject() {
            @Override
            public String getAuthUrl() {
                return "success";
            }
        };

        // Check if either view is called by the interactor
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData loginOutputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                fail("Use case failure is unexpected.");
            }
        };

        LoginDataAccessInterface loginDataAccessInterface = new APIDataAccessObject();

        LoginInputBoundary interactor = new LoginInteractor(loginOAuthDataAccessInterface, successPresenter,
                loginDataAccessInterface);
        assert interactor.execute().equals("success");
    }

    @Test
    void tokenErrorTest() {

        // Create a new getToken method that throws an exception for this test
        LoginOAuthDataAccessInterface loginOAuthDataAccessInterface = new OAuthDataAccessObject() {
            @Override
            public String getToken() {
                throw new OAuthException("Failed to get token.");
            }

            @Override
            public void stopServer() {}
        };

        // Check if prepareFailView is called by the interactor
        LoginOutputBoundary failPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData loginOutputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        LoginDataAccessInterface loginDataAccessInterface = new APIDataAccessObject();

        LoginInteractor interactor = new LoginInteractor(loginOAuthDataAccessInterface, failPresenter,
                loginDataAccessInterface);

        // Call the property change method using a made-up property change event
        interactor.propertyChange(new PropertyChangeEvent(this, "auth_code_received",
                null, 1));
    }

    @Test
    void tokenNullTest() {

        // Create a new getToken method that returns null
        LoginOAuthDataAccessInterface loginOAuthDataAccessInterface = new OAuthDataAccessObject() {
            @Override
            public String getToken() {
                return null;
            }

            @Override
            public void stopServer() {}
        };

        // Check if prepareFailView is called by the interactor
        LoginOutputBoundary failPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData loginOutputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        LoginDataAccessInterface loginDataAccessInterface = new APIDataAccessObject();

        LoginInteractor interactor = new LoginInteractor(loginOAuthDataAccessInterface, failPresenter,
                loginDataAccessInterface);

        // Call the property change method using a made-up property change event
        interactor.propertyChange(new PropertyChangeEvent(this, "auth_code_received",
                null, 1));
    }

    @Test
    void tokenSuccessTest() {
        LoginOAuthDataAccessInterface loginOAuthDataAccessInterface = new OAuthDataAccessObject() {
            @Override
            public String getToken() {
                return "success";
            }

            @Override
            public void stopServer() {}
        };

        LoginDataAccessInterface loginDataAccessInterface = new APIDataAccessObject() {
            @Override
            public List<List> getTournaments() {
                List<String> names = new ArrayList<>();
                names.add("tourney1");
                names.add("tourney2");
                List<Integer> ids = new ArrayList<>();
                List<List> tournaments = new ArrayList<>();
                tournaments.add(names);
                tournaments.add(ids);
                return tournaments;
            }
        };

        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {

            @Override
            public void prepareSuccessView(LoginOutputData loginOutputData) {
                assert loginOutputData.getTournamentNames().equals(Arrays.asList("tourney1", "tourney2"));
            }

            @Override
            public void prepareFailView() {
                fail("Use case failure is unexpected.");
            }
        };

        LoginInteractor interactor = new LoginInteractor(loginOAuthDataAccessInterface, successPresenter,
                loginDataAccessInterface);

        // Call the property change method using a made-up property change event
        interactor.propertyChange(new PropertyChangeEvent(this, "auth_code_received",
                null, 1));
    }
}
