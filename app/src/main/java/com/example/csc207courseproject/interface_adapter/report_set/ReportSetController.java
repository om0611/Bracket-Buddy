
package com.example.csc207courseproject.interface_adapter.report_set;

import com.example.csc207courseproject.entities.Game;
import com.example.csc207courseproject.use_case.report_set.ReportSetInputBoundary;
import com.example.csc207courseproject.use_case.report_set.ReportSetInputData;

import java.util.ArrayList;
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
     * @param p1DQ Whether the first player DQ'd
     * @param p2DQ Wherther the second player DQ's
     */
    public void execute(boolean p1DQ, boolean p2DQ) {

        int setID = currState.getCurrentSet().getSetID();
        int winnerID;

        //Set the winnerID in the case of DQs
        boolean hasDQ = p1DQ || p2DQ;

        if (hasDQ) {
            currState.setSetOver(true);
            if (p2DQ) {
                winnerID = currState.getCurrentSet().getPlayers()[0].getId();
            } else {
                winnerID = currState.getCurrentSet().getPlayers()[1].getId();
            }
        } else {
            //If the set is not over yet, then there is no current winner
            if (currState.getSetOver()) {
                winnerID = currState.getCurrentSet().getWinnerID();
            } else {
                winnerID = -1;
            }
        }

        List<Game> games = currState.getCurrentSet().getGames();

        final ReportSetInputData reportSetInputData = new ReportSetInputData(setID, winnerID, games, hasDQ);

        reportSetUseCaseInteractor.execute(reportSetInputData);
    }

    public void executeTest() {
        //Reports a selected set by entering the values manually rather than keeping them in the state
        int setID = 82752145;
        int p1ID = 18392227;
        int p2ID = 18392226;
        List<Game> games = new ArrayList<Game>();
        Game game1 = new Game();
        game1.report(p2ID, "", "");
        games.add(game1);

        Game game2 = new Game();
        game2.report(p2ID, "", "");
        games.add(game2);

        Game game3 = new Game();
        game3.report(p1ID, "", "");
        games.add(game3);

        Game game4 = new Game();
        game4.report(p2ID, "", "");
        games.add(game4);

        final ReportSetInputData reportSetTestInputData = new ReportSetInputData(setID, p2ID, games, true);

        reportSetUseCaseInteractor.execute(reportSetTestInputData);
    }

}
