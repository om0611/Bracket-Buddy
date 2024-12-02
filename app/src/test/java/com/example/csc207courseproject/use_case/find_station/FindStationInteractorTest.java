package com.example.csc207courseproject.use_case.find_station;

import com.example.csc207courseproject.entities.CallSetData;
import com.example.csc207courseproject.entities.Entrant;
import com.example.csc207courseproject.entities.Station;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

class FindStationInteractorTest {

    @Test
    void oneStreamStationTest() {

        // Create example input data
        Entrant en1 = new Entrant(null, 1);
        Entrant en2 = new Entrant(null, 2);
        Station s = new Station(1, 1);
        s.addTag("Stream setup");
        List<Station> stations = new ArrayList<>();
        stations.add(s);
        CallSetData exampleSet = new CallSetData(1, new Entrant[] {en1, en2});

        FindStationInputData inputData = new FindStationInputData(exampleSet, stations);

        // Create test presenter
        FindStationOutputBoundary failPresenter = new FindStationOutputBoundary(){
            @Override
            public void prepareSuccessView(FindStationOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView() {
                assert true;
            }
        };

        FindStationInputBoundary interactor = new FindStationInteractor(failPresenter);
        interactor.execute(inputData);
    }

    @Test
    void oneOpenStationTest() {

        // Create example input data
        Entrant en1 = new Entrant(null, 1);
        Entrant en2 = new Entrant(null, 2);
        Station s = new Station(1, 1);
        List<Station> stations = new ArrayList<>();
        stations.add(s);
        CallSetData exampleSet = new CallSetData(1, new Entrant[] {en1, en2});

        FindStationInputData inputData = new FindStationInputData(exampleSet, stations);

        // Create test presenter
        FindStationOutputBoundary successPresenter = new FindStationOutputBoundary(){
            @Override
            public void prepareSuccessView(FindStationOutputData outputData) {
                assert (outputData.getStation() == s && outputData.getOpenStream() == null);
            }

            @Override
            public void prepareFailView() {
                fail("Use case fail is unexpected.");
            }
        };

        FindStationInputBoundary interactor = new FindStationInteractor(successPresenter);
        interactor.execute(inputData);
    }
}
