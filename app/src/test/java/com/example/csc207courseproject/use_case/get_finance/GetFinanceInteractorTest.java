package com.example.csc207courseproject.use_case.get_finance;

import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Participant;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class GetFinanceInteractorTest {

    /**
     * Test the success case for the get finance use case.
     */
    @Test
    void getFinanceSuccessTest() {
        GetFinanceInputData inputData = new GetFinanceInputData(1);
        HashMap<Integer, Participant> testParticipants = new HashMap<>();
        testParticipants.put(1, new Participant(1, 0, "Test Player", "test"));

        // Create mock data access object that returns test data
        GetFinanceDataAccessInterface successDataAccessInterface = new GetFinanceDataAccessInterface() {
            @Override
            public HashMap<Integer, Participant> fetchParticipantPaymentStatus(int eventID) {
                return testParticipants;
            }

            @Override
            public String getTournamentSlug(String eventID) {
                return "";
            }
        };

        // Create mock presenter to verify success
        GetFinanceOutputBoundary successPresenter = new GetFinanceOutputBoundary() {
            @Override
            public void prepareSuccessView(GetFinanceOutputData data) {
                List<String> entries = data.getFinanceEntries();
                assertEquals(1, entries.size());
                assertEquals("1, Test Player, Status: Unpaid", entries.get(0));
            }

            @Override
            public void prepareFailView() {
                fail("Use case failure is unexpected.");
            }
        };

        GetFinanceInputBoundary interactor = new GetFinanceInteractor(
                successDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }
    
    
     /**
     * Test the failure case for the get finance use case.
     */
    @Test
    void getFinanceFailureTest() {
        GetFinanceInputData inputData = new GetFinanceInputData(1);

        // Create mock data access object that throws an exception
        GetFinanceDataAccessInterface failDataAccessInterface = new GetFinanceDataAccessInterface() {
            @Override
            public HashMap<Integer, Participant> fetchParticipantPaymentStatus(int eventID) {
                throw new RuntimeException("API failure");
            }

            @Override
            public String getTournamentSlug(String eventID) {
                throw new RuntimeException("API failure");  
            }
        };

        // Create mock presenter to verify failure
        GetFinanceOutputBoundary failPresenter = new GetFinanceOutputBoundary() {
            @Override
            public void prepareSuccessView(GetFinanceOutputData data) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                // Test passes if prepareFailView is called
            }
        };

        GetFinanceInputBoundary interactor = new GetFinanceInteractor(
                failDataAccessInterface, failPresenter);
        interactor.execute(inputData);
    }
}
