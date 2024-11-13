package use_case.select_phase;

import data_access.APIDataAccessObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SelectPhaseInteractorTest {

    @Test
    void selectPhaseFailureTest() {
        SelectPhaseInputData inputData = new SelectPhaseInputData(0);

        // Create new setSeeding method which throws an exception for this test
        APIDataAccessObject failDataAccessInterface = new APIDataAccessObject() {
            @Override
            public List<Integer> getSeedingInPhase(int phaseID) {
                throw new UnsupportedOperationException("Failure");
            }
        };

        SelectPhaseOutputBoundary failPresenter = new SelectPhaseOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectPhaseOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Something went wrong with the API call, try again.", error);
            }
        };

        SelectPhaseInputBoundary interactor = new SelectPhaseInteractor(failDataAccessInterface, failPresenter);
        interactor.execute(inputData);
    }

}
