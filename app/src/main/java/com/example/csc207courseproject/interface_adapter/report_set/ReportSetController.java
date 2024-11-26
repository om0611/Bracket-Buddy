
package com.example.csc207courseproject.interface_adapter.report_set;

import com.example.csc207courseproject.entities.Game;
import com.example.csc207courseproject.use_case.report_set.ReportSetInputBoundary;
import com.example.csc207courseproject.use_case.report_set.ReportSetInputData;

import java.util.List;

/**
 * The controller for the Report Set Use case
 */
public class ReportSetController {


    private final ReportSetInputBoundary reportSetUseCaseInteractor;
    private final ReportSetState currState;

    public ReportSetController(ReportSetInputBoundary reportSetUseCaseInteractor, ReportSetState currState) {
        this.reportSetUseCaseInteractor = reportSetUseCaseInteractor;
        this.currState = currState;
    }

    /**
     * Execute the report set use case
     */
    public void execute(boolean hasDQ) {

        int setID = currState.getCurrentSet().getSetID();
        int winnerID;

        if (currState.getSetOver()) {
            winnerID = currState.getCurrentSet().getWinnerID();
        } else {
            winnerID = -1;
        }

        List<Game> games = currState.getCurrentSet().getGames();

        final ReportSetInputData reportSetInputData = new ReportSetInputData(setID, winnerID, games, hasDQ);

        reportSetUseCaseInteractor.execute(reportSetInputData);
    }

}
