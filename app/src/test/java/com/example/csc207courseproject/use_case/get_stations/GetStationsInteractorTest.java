package com.example.csc207courseproject.use_case.get_stations;

import com.example.csc207courseproject.data_access.api.APIDataAccessException;
import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Station;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class GetStationsInteractorTest {

    @BeforeAll
    static void setUpBeforeClass() {
        // Create test EventData
        EventData.createEventData(0,0, "", null, null, null, null);
    }

    @Test
    void mutateFailureTest() {

        // Create sample input data
        GetStationsInputData inputData = new GetStationsInputData(new ArrayList<>());

        // Create new getStations method which throws an exception for this test
        GetStationsDataAccessInterface failDataAccessInterface = new GetStationsDataAccessInterface() {
            @Override
            public List<Station> getStations(int eventId) {
                throw new APIDataAccessException("Failure");
            }
        };

        GetStationsOutputBoundary failPresenter = new GetStationsOutputBoundary() {
            @Override
            public void prepareSuccessView(GetStationsOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        GetStationsInputBoundary interactor = new GetStationsInteractor(failDataAccessInterface, failPresenter);
        interactor.execute(inputData);
    }

    @Test
    void successTest() {

        // Create sample input data
        GetStationsInputData inputData = new GetStationsInputData(new ArrayList<>());

        // Create new getStations method which throws an exception for this test
        GetStationsDataAccessInterface successDataAccessInterface = new GetStationsDataAccessInterface() {
            @Override
            public List<Station> getStations(int eventId) {
                return new ArrayList<>();
            }
        };

        GetStationsOutputBoundary successPresenter = new GetStationsOutputBoundary() {
            @Override
            public void prepareSuccessView(GetStationsOutputData outputData) {
                assert outputData.getStations() != null;
            }

            @Override
            public void prepareFailView() {
                fail("Use case fail is unexpected.");
            }
        };

        GetStationsInputBoundary interactor = new GetStationsInteractor(successDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }

}
