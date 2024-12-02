package com.example.csc207courseproject.use_case.modify_finance;

import com.example.csc207courseproject.entities.Participant;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ModifyFinanceInteractorTest {

    /**
     * Test the success case for the modify finance use case.
     */
    @Test
    void modifyFinanceSuccessTest() {
        // Create test input data with valid payment amounts
        ModifyFinanceInputData inputData = new ModifyFinanceInputData(
                50, 0, 1, ""
        );

        Map<Integer, Participant> testParticipants = new HashMap<>();
        testParticipants.put(1, new Participant(1, 1, "Test Player", "test"));

        // Create mock data access object that simulates successful operations
        ModifyFinanceDataAccessInterface successDataAccessInterface = new ModifyFinanceDataAccessInterface() {
            @Override
            public void modifyParticipantPaymentStatus(int participantId) {
                // Simulate successful modification
                Participant participant = testParticipants.get(participantId);
                assert participant != null;
                participant.markAsPaid();

            }

            @Override
            public void modifyParticipantCashPaid(int participantId, String amount) {
                // Simulate successful modification
                Participant participant = testParticipants.get(participantId);
                assert participant != null;
                participant.setCashPaid(amount);
            }

            @Override
            public void modifyParticipanteTransferPaid(int participantId, String amount) {
                // Simulate successful modification
                Participant participant = testParticipants.get(participantId);
                assert participant != null;
                participant.seteTransferPaid(amount);
            }

            @Override
            public void modifyParticipantSpecialNotes(int participantId, String notes) {
                // Simulate successful modification
                Participant participant = testParticipants.get(participantId);
                assert participant != null;
                participant.setSpecialNotes(notes);
            }

            @Override
            public Map<Integer, Participant> getParticipantPaymentStatus() {
                return testParticipants;
            }
        };

        // Create mock presenter to verify success
        ModifyFinanceOutputBoundary successPresenter = new ModifyFinanceOutputBoundary() {
            @Override
            public void prepareSuccessView(ModifyFinanceOutputData data) {
                List<String> entries = data.getUpdatedPaymentStatuses();
                assertEquals(1, entries.size());
                assertEquals("1, Test Player, Status: Paid", entries.get(0));
                assertEquals(1, data.getParticipantID());
            }

            @Override
            public void prepareFailView() {
                fail("Use case failure is unexpected.");
            }
        };

        ModifyFinanceInputBoundary interactor = new ModifyFinanceInteractor(
                successDataAccessInterface, successPresenter);
        interactor.execute(inputData);
    }

    /**
     * Test the failure case for the modify finance use case.
     */
    @Test
    void modifyFinanceFailureTest() {
        ModifyFinanceInputData inputData = new ModifyFinanceInputData(
                50, 0, 1, ""
        );

        // Create mock data access object that throws an exception
        ModifyFinanceDataAccessInterface failDataAccessInterface = new ModifyFinanceDataAccessInterface() {
            @Override
            public void modifyParticipantPaymentStatus(int participantId) {
                throw new RuntimeException("API failure");
            }

            @Override
            public void modifyParticipantCashPaid(int participantId, String amount) {
                throw new RuntimeException("API failure");
            }

            @Override
            public void modifyParticipanteTransferPaid(int participantId, String amount) {
                throw new RuntimeException("API failure");
            }

            @Override
            public void modifyParticipantSpecialNotes(int participantId, String notes) {
                throw new RuntimeException("API failure");
            }

            @Override
            public Map<Integer, Participant> getParticipantPaymentStatus() {
                throw new RuntimeException("API failure");
            }
        };

        // Create mock presenter to verify failure
        ModifyFinanceOutputBoundary failPresenter = new ModifyFinanceOutputBoundary() {
            @Override
            public void prepareSuccessView(ModifyFinanceOutputData data) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                // Test passes if prepareFailView is called
            }
        };

        ModifyFinanceInputBoundary interactor = new ModifyFinanceInteractor(
                failDataAccessInterface, failPresenter);
        interactor.execute(inputData);
    }
}
