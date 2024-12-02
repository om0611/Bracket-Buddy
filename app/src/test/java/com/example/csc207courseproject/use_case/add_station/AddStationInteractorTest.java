package com.example.csc207courseproject.use_case.add_station;

import com.example.csc207courseproject.data_access.api.APIDataAccessException;
import com.example.csc207courseproject.data_access.api.APIDataAccessObject;
import com.example.csc207courseproject.entities.EventData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class AddStationInteractorTest {

    @BeforeAll
    static void setUpBeforeClass() {
        // Create test EventData
        EventData.createEventData(0,0, "", null, null, null, null);
    }

    @Test
    void mutateFailureTest() {

        // Create sample input data
        AddStationInputData inputData = new AddStationInputData(1);

        // Create new getOngoingSets method which throws an exception for this test
        AddStationDataAccessInterface failDataAccessInterface = new APIDataAccessObject() {
            @Override
            public int addStation(int tournamentId, int stationNum) {
                throw new APIDataAccessException("Failure");
            }
        };

        AddStationOutputBoundary failPresenter = new AddStationOutputBoundary() {
            @Override
            public void prepareSuccessView(AddStationOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        AddStationInputBoundary interactor = new AddStationInteractor(failDataAccessInterface, failPresenter);
        interactor.execute(inputData);
    }

    @Test
    void successTest() {
        // Create sample input data
        AddStationInputData inputData = new AddStationInputData(1);

        // Create new getOngoingSets method which throws an exception for this test
        AddStationDataAccessInterface successDataAccessInterface = new APIDataAccessObject() {
            @Override
            public int addStation(int tournamentId, int stationNum) {
                return 1;
            }
        };

        AddStationOutputBoundary successPresenter = new AddStationOutputBoundary() {
            @Override
            public void prepareSuccessView(AddStationOutputData outputData) {
                assert outputData.getStation().getId() == 1;
            }

            @Override
            public void prepareFailView() {
                fail("Use case fail is unexpected.");
            }
        };

        AddStationInputBoundary interactor = new AddStationInteractor(successDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }

}
