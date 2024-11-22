package com.example.csc207courseproject.use_case.report_game;


public class ReportGameInteractor implements ReportGameInputBoundary {

    private final ReportGameOutputBoundary reportGamePresenter;

    public ReportGameInteractor(ReportGameOutputBoundary reportGamePresenter) {
        this.reportGamePresenter = reportGamePresenter;
    }

    @Override
    public void execute(ReportGameInputData updateSeedingInputData) {
        // Check if the input is correct, which it should be because of dropdown menus actually
    }

}
