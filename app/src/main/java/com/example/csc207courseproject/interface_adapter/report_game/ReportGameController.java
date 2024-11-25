package com.example.csc207courseproject.interface_adapter.report_game;

import com.example.csc207courseproject.interface_adapter.report_set.ReportSetState;
import com.example.csc207courseproject.use_case.report_game.ReportGameInputBoundary;


public class ReportGameController {
    private final ReportGameInputBoundary reportGameUseCaseInteractor;
    private final ReportSetState setState;

    public ReportGameController(ReportGameInputBoundary reportGameUseCaseInteractor, ReportSetState setState) {
        this.reportGameUseCaseInteractor = reportGameUseCaseInteractor;
        this.setState = setState;
    }


    /**
     * Execute the report game use case
     */
    public void execute(String selectedPhase) {


    }
}
