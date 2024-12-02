package com.example.csc207courseproject.use_case.report_game;

import com.example.csc207courseproject.entities.Entrant;
import com.example.csc207courseproject.entities.Game;
import com.example.csc207courseproject.entities.ReportSetData;
import org.junit.jupiter.api.Test;

class ReportGameInteractorTest {

    @Test
    void completeSetTest() {

        // Create example input data of an almost completed set
        Entrant en1 = new Entrant(null, 1);
        Entrant en2 = new Entrant(null, 2);
        ReportSetData exampleSet = new ReportSetData(1, new Entrant[] {en1, en2}, 5);

        Game g2 = new Game();
        Game g3 = new Game();
        exampleSet.getGame(1).setWinnerID(1);
        g2.setWinnerID(1);
        exampleSet.getGames().add(g2);
        exampleSet.getGames().add(g3);

        ReportGameInputData inputData = new ReportGameInputData(exampleSet, 3, 1);

        // Create test presenter
        ReportGameOutputBoundary setOverPresenter = outputData -> {
            assert outputData.getSetOver();
        };

        ReportGameInputBoundary interactor = new ReportGameInteractor(setOverPresenter);
        interactor.execute(inputData);
    }

    @Test
    void incompleteSetTest() {

        // Create example input data of an incomplete set
        Entrant en1 = new Entrant(null, 1);
        Entrant en2 = new Entrant(null, 2);
        ReportSetData exampleSet = new ReportSetData(1, new Entrant[]{en1, en2}, 5);

        Game g2 = new Game();
        Game g3 = new Game();
        exampleSet.getGame(1).setWinnerID(1);
        g2.setWinnerID(2);
        exampleSet.getGames().add(g2);
        exampleSet.getGames().add(g3);

        ReportGameInputData inputData = new ReportGameInputData(exampleSet, 3, 1);

        // Create test presenter
        ReportGameOutputBoundary setNotOverPresenter = outputData -> {
            assert !outputData.getSetOver();
        };

        ReportGameInputBoundary interactor = new ReportGameInteractor(setNotOverPresenter);
        interactor.execute(inputData);
    }
}
