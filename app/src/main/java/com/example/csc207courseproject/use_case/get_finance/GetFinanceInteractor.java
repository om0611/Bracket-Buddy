package com.example.csc207courseproject.use_case.get_finance;

import android.annotation.SuppressLint;

import android.media.metrics.Event;
import com.example.csc207courseproject.data_access.api.APIDataAccessException;
import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Participant;

import java.util.ArrayList;
import java.util.List;

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
            int tournamentId = EventData.getEventData().getTournamentId();
            // Fetch finance data from the data access object
            dataAccess.fetchParticipantPaymentStatus(tournamentId);

            List<Participant> financeEntries = new ArrayList<>(EventData.getEventData().getParticipants().values());
            List<String> output = new ArrayList<>();

            for (Participant participant : financeEntries) {
                output.add(participant.getFinancialEntry());
            }
            GetFinanceOutputData financeOutputData = new GetFinanceOutputData(output);

            // Pass the data to the presenter for preparing the success view
            presenter.prepareSuccessView(financeOutputData);
        } catch (APIDataAccessException e) {
            // Handle any potential errors by passing the error to the presenter
            presenter.prepareFailView();
        }
    }
}
