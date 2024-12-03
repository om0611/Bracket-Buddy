package com.example.csc207courseproject.use_case.select_event;

import com.example.csc207courseproject.data_access.api.APIDataAccessException;
import com.example.csc207courseproject.data_access.api.APIDataAccessObject;
import com.example.csc207courseproject.entities.EventData;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.fail;

class SelectEventInteractorTest {

    @Test
    void getEventDataFailureTest() {
        SelectEventDataAccessInterface selectEventDataAccessInterface = new APIDataAccessObject() {
            @Override
            public List<Object> getEventData(Integer eventID) {
                throw new APIDataAccessException("Failed to get event data");
            }
        };

        SelectEventOutputBoundary failPresenter = new SelectEventOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                fail("Use case success is not expected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        SelectEventInputBoundary interactor = new SelectEventInteractor(selectEventDataAccessInterface, failPresenter);
        interactor.execute(1, "rock paper scissors", 10);
    }

    @Test
    void getEventDataSuccessTest() {
        SelectEventDataAccessInterface selectEventDataAccessInterface = new APIDataAccessObject() {
            @Override
            public List<Object> getEventData(Integer eventID) {
                List<Object> eventData = new ArrayList<>();
                eventData.add(new HashMap<>());
                eventData.add(new HashMap<>());
                eventData.add(new TreeMap<>());
                eventData.add(new TreeMap<>());
                return eventData;
            }
        };

        SelectEventOutputBoundary successPresenter = new SelectEventOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                assert EventData.getEventData().getEventName().equals("rock paper scissors");
            }

            @Override
            public void prepareFailView() {
                fail("Use case failure is not expected.");
            }
        };

        SelectEventInputBoundary interactor = new SelectEventInteractor(selectEventDataAccessInterface,
                successPresenter);
        interactor.execute(1, "rock paper scissors", 10);
    }
}
