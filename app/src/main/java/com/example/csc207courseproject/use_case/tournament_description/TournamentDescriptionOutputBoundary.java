package com.example.csc207courseproject.use_case.tournament_description;

public interface TournamentDescriptionOutputBoundary {

    /**
     * Prepares the success view for the Tournament Description Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(TournamentDescriptionOutputData outputData);

    /**
     * Prepares the failure view for the Tournament Description Use Case.
     */
    void prepareFailView(String errorMessage);

}