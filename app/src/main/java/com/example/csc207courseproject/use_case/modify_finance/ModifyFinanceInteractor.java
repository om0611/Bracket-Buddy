package com.example.csc207courseproject.use_case.modify_finance;

import android.annotation.SuppressLint;

import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Participant;
import com.example.csc207courseproject.entities.Station;
import com.example.csc207courseproject.use_case.call_set.CallSetOutputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ModifyFinanceInteractor implements ModifyFinanceInputBoundary {

    private final ModifyFinanceDataAccessInterface dataAccess;
    private final ModifyFinanceOutputBoundary presenter;

    /**
     * Construct a new ModifyFinanceInteractor with the given data access and presenter.
     *
     * @param dataAccess the data access interface.
     * @param presenter the output boundary.
     */
    public ModifyFinanceInteractor(ModifyFinanceDataAccessInterface dataAccess, ModifyFinanceOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    /**
     * Execute the logic for the modify finance use case.
     * @param inputData The input data containing event information
     */
    @Override
    public void execute(ModifyFinanceInputData inputData) {
        try {
            if (inputData.geteTransferAmount() > 0 || inputData.getCashAmount() > 0) {
                dataAccess.modifyParticipantPaymentStatus(inputData.getParticipantID());
                dataAccess.modifyParticipantCashPaid(inputData.getParticipantID(), String.valueOf(inputData.getCashAmount()));
                dataAccess.modifyParticipanteTransferPaid(inputData.getParticipantID(), String.valueOf(inputData.geteTransferAmount()));
                dataAccess.modifyParticipantSpecialNotes(inputData.getParticipantID(), inputData.getSpecialNote());
                
                Map<Integer, Participant> updatedPaymentStatuses = dataAccess.getParticipantPaymentStatus();

                List<String> updatedPaymentStatusesList = convertMapToList(updatedPaymentStatuses);
                ModifyFinanceOutputData outputData = new ModifyFinanceOutputData(updatedPaymentStatusesList, inputData.getParticipantID());

                // update the view
                presenter.prepareSuccessView(outputData);
            }

        } catch (Exception e) {
            presenter.prepareFailView();
        }
    }

    /**
     * Convert a map of participants to a list of strings.
     *
     * @param entries the map of participants.
     * @return the list of strings.
     */
    private List<String> convertMapToList(Map<Integer, Participant> entries) {
        List<String> defaultEntries = new ArrayList<>();
        for (Participant participant : entries.values()) {
            @SuppressLint("DefaultLocale") String entry = String.format(
                    "%d, %s, Status: %s",
                    participant.getParticipantId(),
                    participant.getName(),
                    participant.isPaid() ? "Paid" : "Unpaid"
            );
            defaultEntries.add(entry);
        }
        return defaultEntries;
    }
}
