package com.example.csc207courseproject.use_case.decline_set;

import com.example.csc207courseproject.entities.CallSetData;
import com.example.csc207courseproject.entities.Entrant;
import com.example.csc207courseproject.entities.Station;
import org.junit.jupiter.api.Test;

class DeclineSetInteractorTest {

    @Test
    void allTagsApplyTest() {

        // Create example input data
        Entrant en1 = new Entrant(null, 1);
        Entrant en2 = new Entrant(null, 2);
        Station s = new Station(1, 1);
        CallSetData exampleSet = new CallSetData(1, new Entrant[] {en1, en2});
        exampleSet.setStation(s);

        DeclineSetInputData inputData = new DeclineSetInputData("test", true, true, exampleSet);

        // Create test presenter
        DeclineSetOutputBoundary setOverPresenter = new DeclineSetOutputBoundary(){
            @Override
            public void prepareSuccessView() {
                assert (en1.getTags().get(0).equals("test") && en2.getTags().get(0).equals("test") && s.hasTag("test"));
            }
        };

        DeclineSetInputBoundary interactor = new DeclineSetInteractor(setOverPresenter);
        interactor.execute(inputData);
    }

    @Test
    void noTagsApplyTest() {

        // Create example input data
        Entrant en1 = new Entrant(null, 1);
        Entrant en2 = new Entrant(null, 2);
        Station s = new Station(1, 1);
        CallSetData exampleSet = new CallSetData(1, new Entrant[] {en1, en2});
        exampleSet.setStation(s);

        DeclineSetInputData inputData = new DeclineSetInputData("test", false, false, exampleSet);

        // Create test presenter
        DeclineSetOutputBoundary setOverPresenter = new DeclineSetOutputBoundary(){
            @Override
            public void prepareSuccessView() {
                assert (en1.getTags().isEmpty() && en2.getTags().isEmpty() && s.hasTag("test"));
            }
        };

        DeclineSetInputBoundary interactor = new DeclineSetInteractor(setOverPresenter);
        interactor.execute(inputData);
    }
}
