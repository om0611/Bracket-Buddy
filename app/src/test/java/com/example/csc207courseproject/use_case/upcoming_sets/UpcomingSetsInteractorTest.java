package com.example.csc207courseproject.use_case.upcoming_sets;

import com.example.csc207courseproject.data_access.api.APIDataAccessException;
import com.example.csc207courseproject.entities.CallSetData;
import com.example.csc207courseproject.entities.Entrant;
import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Station;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class UpcomingSetsInteractorTest {

    @BeforeAll
    static void setUpBeforeClass() {
        // Create test EventData
        EventData.createEventData(0,0, "", null, null, null, null);
    }

    @Test
    void mutateFailureTest() {

        // Create sample input data
        UpcomingSetsInputData inputData = new UpcomingSetsInputData(new ArrayList<>());

        // Create new UpcomingSets method which throws an exception for this test
        UpcomingSetsDataAccessInterface failDataAccessInterface = new UpcomingSetsDataAccessInterface() {
            @Override
            public List<CallSetData> getUpcomingSets(int eventId) {
                throw new APIDataAccessException("Failure");
            }
        };

        UpcomingSetsOutputBoundary failPresenter = new UpcomingSetsOutputBoundary() {
            @Override
            public void prepareSuccessView(UpcomingSetsOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        UpcomingSetsInputBoundary interactor = new UpcomingSetsInteractor(failDataAccessInterface, failPresenter);
        interactor.execute(inputData);
    }

    @Test
    void setIsRepeatTest() {

        // Create sample input data
        List<Integer> setIds = new ArrayList<>();
        setIds.add(1);
        UpcomingSetsInputData inputData = new UpcomingSetsInputData(setIds);

        // Create new getUpcomingSets method which returns a single set
        UpcomingSetsDataAccessInterface successDataAccessInterface = new UpcomingSetsDataAccessInterface() {
            @Override
            public List<CallSetData> getUpcomingSets(int eventId) {
                CallSetData returnSet = new CallSetData(1, null);
                List<CallSetData> sets = new ArrayList<>();
                sets.add(returnSet);
                return sets;
            }
        };

        UpcomingSetsOutputBoundary successPresenter = new UpcomingSetsOutputBoundary() {
            @Override
            public void prepareSuccessView(UpcomingSetsOutputData outputData) {
                assert outputData.getUpcomingSets().isEmpty();
            }

            @Override
            public void prepareFailView() {
                fail("Use case fail is unexpected.");
            }
        };

        UpcomingSetsInputBoundary interactor = new UpcomingSetsInteractor(successDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void oneUniqueSetTest() {

        // Create sample input data
        List<Integer> setIds = new ArrayList<>();
        setIds.add(1);
        UpcomingSetsInputData inputData = new UpcomingSetsInputData(setIds);

        // Create new getUpcomingSets method which returns a single set
        UpcomingSetsDataAccessInterface successDataAccessInterface = new UpcomingSetsDataAccessInterface() {
            @Override
            public List<CallSetData> getUpcomingSets(int eventId) {
                // Create example set
                Entrant en1 = new Entrant(null, 1);
                Entrant en2 = new Entrant(null, 2);
                Station s = new Station(2, 2);
                en1.setCurrentStation(s);
                CallSetData returnSet = new CallSetData(2, new Entrant[]{en1, en2});
                List<CallSetData> sets = new ArrayList<>();
                sets.add(returnSet);
                return sets;
            }
        };

        UpcomingSetsOutputBoundary successPresenter = new UpcomingSetsOutputBoundary() {
            @Override
            public void prepareSuccessView(UpcomingSetsOutputData outputData) {
                assert outputData.getUpcomingSets().get(0).getSetID() == 2;
            }

            @Override
            public void prepareFailView() {
                fail("Use case fail is unexpected.");
            }
        };

        UpcomingSetsInputBoundary interactor = new UpcomingSetsInteractor(successDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }

}
