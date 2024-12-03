package com.example.csc207courseproject.use_case.export_finance;

import com.example.csc207courseproject.entities.Participant;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ExportFinanceInteractorTest {

    /**
     * Test the success case for the export finance use case.
     */
    @Test
    void exportFinanceSuccessTest() {
        File file = new File("test.csv");
        ExportFinanceInputData inputData = new ExportFinanceInputData(file);
        Map<Integer, Participant> testParticipants = new HashMap<>();
        testParticipants.put(1, new Participant(1, 1, "TestPlayer1", "test"));
        testParticipants.put(2, new Participant(2, 2, "TestPlayer2", "test"));

        // Create mock data access object that simulates successful operations
        ExportFinanceDataAccessInterface successDataAccessInterface = new ExportFinanceDataAccessInterface() {
            @Override
            public Map<Integer, Participant> getParticipantPaymentStatus() {
                return testParticipants;
            }
        };

        ExportFinanceOutputBoundary successPresenter = new ExportFinanceOutputBoundary() {
            @Override
            public void prepareSuccessView(ExportFinanceOutputData outputData) {
                // no outputData
            }

            @Override
            public void prepareFailView() {
                // no outputData
            }
        };
        


        ExportFinanceInputBoundary interactor = new ExportFinanceInteractor(
                successDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }

    /**
     * Test the failure case for the export finance use case.
     */
    @Test
    void exportFinanceFailureTest() {
        File file = new File("test.csv");
        ExportFinanceInputData inputData = new ExportFinanceInputData(file);

        // Create mock data access object that throws an exception
        ExportFinanceDataAccessInterface failDataAccessInterface = new ExportFinanceDataAccessInterface() {
            @Override
            public Map<Integer, Participant> getParticipantPaymentStatus() {
                throw new RuntimeException("API failure");
            }
        };

        // Create mock presenter to verify failure
        ExportFinanceOutputBoundary failPresenter = new ExportFinanceOutputBoundary() {
            @Override
            public void prepareSuccessView(ExportFinanceOutputData data) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                // Test passes if prepareFailView is called
            }
        };

        ExportFinanceInputBoundary interactor = new ExportFinanceInteractor(
                failDataAccessInterface, failPresenter);
        interactor.execute(inputData);
    }
}
