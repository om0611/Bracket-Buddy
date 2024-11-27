package com.example.csc207courseproject.use_case.report_game;

public interface ReportGameOutputBoundary {

    /**
     * Prepares the success view for the Update Seeding Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(ReportGameOutputData outputData);

    /**
     * Prepares the failure view for the Update Seeding Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

}
