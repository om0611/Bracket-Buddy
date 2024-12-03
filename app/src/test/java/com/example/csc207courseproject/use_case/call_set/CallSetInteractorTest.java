package com.example.csc207courseproject.use_case.call_set;

import com.example.csc207courseproject.data_access.api.APIDataAccessException;
import com.example.csc207courseproject.data_access.api.APIDataAccessObject;
import com.example.csc207courseproject.entities.Station;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class CallSetInteractorTest {

    @Test
    void mutateFailureTest() {

        // Create sample input data
        Station testStation = new Station(1, 1);
        CallSetInputData inputData = new CallSetInputData(1, testStation);

        // Create new callSet method which throws an exception for this test
        CallSetDataAccessInterface failDataAccessInterface = new CallSetDataAccessInterface() {
            @Override
            public void callSet(int setId) {
                throw new APIDataAccessException("Failure");
            }
        };

        CallSetOutputBoundary failPresenter = new CallSetOutputBoundary() {
            @Override
            public void prepareSuccessView(CallSetOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        CallSetInputBoundary interactor = new CallSetInteractor(failDataAccessInterface, failPresenter);
        interactor.execute(inputData);
    }

    @Test
    void successTest() {
        // Create sample input data
        Station testStation = new Station(1, 1);
        CallSetInputData inputData = new CallSetInputData(1, testStation);

        // Create new callSet method which returns
        CallSetDataAccessInterface successDataAccessInterface = new CallSetDataAccessInterface() {
            @Override
            public void callSet(int setId) {
                return;
            }
        };

        CallSetOutputBoundary successPresenter = new CallSetOutputBoundary() {
            @Override
            public void prepareSuccessView(CallSetOutputData outputData) {
                assert !outputData.getStation().isNotOccupied();
            }

            @Override
            public void prepareFailView() {
                fail("Use case fail is unexpected.");
            }
        };

        CallSetInputBoundary interactor = new CallSetInteractor(successDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }

}
