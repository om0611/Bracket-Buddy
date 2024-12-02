package com.example.csc207courseproject.use_case.get_finance;

import android.annotation.SuppressLint;

import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Participant;
import com.example.csc207courseproject.entities.Station;
import com.example.csc207courseproject.use_case.call_set.CallSetOutputData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetFinanceInteractor implements GetFinanceInputBoundary {

    private final GetFinanceDataAccessInterface dataAccess;
    private final GetFinanceOutputBoundary presenter;

    /**
     * Construct a new GetFinanceInteractor with the given data access and presenter.
     *
     * @param dataAccess the data access interface.
     * @param presenter the output boundary.
     */
    public GetFinanceInteractor(GetFinanceDataAccessInterface dataAccess, GetFinanceOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    /**
     * Execute the logic for the get finance use case.
     * @param inputData The input data containing event information
     */
    @Override
    public void execute(GetFinanceInputData inputData) {
        try {
            int eventId = inputData.getEventID();
            // Fetch finance data from the data access object
            List<String> financeEntries = convertMapToList(dataAccess.fetchParticipantPaymentStatus(eventId));

            GetFinanceOutputData financeOutputData = new GetFinanceOutputData(financeEntries);

            // Pass the data to the presenter for preparing the success view
            presenter.prepareSuccessView(financeOutputData);
        } catch (Exception e) {
            // Handle any potential errors by passing the error to the presenter
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
