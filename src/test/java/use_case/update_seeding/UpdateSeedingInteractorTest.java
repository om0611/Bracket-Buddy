package use_case.update_seeding;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UpdateSeedingInteractorTest {

    @Test
    void successTest() {
        UpdateSeedingInputData inputData = new UpdateSeedingInputData(1, 3, 8);

        UpdateSeedingOutputBoundary successPresenter = new UpdateSeedingOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateSeedingOutputData changed) {
                assertEquals(1, changed.getOldSeed());
                assertEquals(3, changed.getNewSeed());

            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        UpdateSeedingInputBoundary interactor = new UpdateSeedingInteractor(successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void invalidSeedNumberTest() {
        UpdateSeedingInputData inputData = new UpdateSeedingInputData(-5, 3, 8);

        UpdateSeedingOutputBoundary failPresenter = new UpdateSeedingOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateSeedingOutputData changed) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("These are not valid seeds.", error);
            }
        };

        UpdateSeedingInputBoundary interactor = new UpdateSeedingInteractor(failPresenter);
        interactor.execute(inputData);
    }

}
