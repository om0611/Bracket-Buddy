package com.example.csc207courseproject.use_case.select_tournament;

import com.example.csc207courseproject.data_access.api.APIDataAccessObject;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class SelectTournamentInteractorTest {

    @Test
    void getEventsFailureTest() {

        // Create new getEventsInTournament method which throws an exception for this test
        SelectTournamentDataAccessInterface selectTournamentDataAccessInterface = new APIDataAccessObject() {
            @Override
            public List<List> getEventsInTournament(Integer tournamentID) throws JSONException {
                throw new JSONException("Failed to get events.");
            }
        };

        SelectTournamentOutputBoundary failPresenter = new SelectTournamentOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectTournamentOutputData selectTournamentOutputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        SelectTournamentInputBoundary interactor = new SelectTournamentInteractor(failPresenter,
                selectTournamentDataAccessInterface);
        interactor.execute(1);
    }

    @Test
    void getEventsSuccessTest() {
        SelectTournamentDataAccessInterface selectTournamentDataAccessInterface = new APIDataAccessObject() {
            @Override
            public List<List> getEventsInTournament(Integer tournamentID) {
                List<String> names = new ArrayList<>();
                names.add("event1");
                names.add("event2");
                List<Integer> ids = new ArrayList<>();
                List<List> events = new ArrayList<>();
                events.add(names);
                events.add(ids);
                return events;
            }
        };

        SelectTournamentOutputBoundary successPresenter = new SelectTournamentOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectTournamentOutputData selectTournamentOutputData) {
                assert selectTournamentOutputData.getEventNames().equals(Arrays.asList("event1", "event2"));
            }

            @Override
            public void prepareFailView() {
                fail("Use case failure is unexpected.");
            }
        };

        SelectTournamentInputBoundary interactor = new SelectTournamentInteractor(successPresenter,
                selectTournamentDataAccessInterface);
        interactor.execute(1);
    }
}
