package interface_adapter.update_seeding;

import use_case.update_seeding.UpdateSeedingInputData;
import use_case.update_seeding.UpdateSeedingInputBoundary;
import interface_adapter.update_seeding.SeedingState;

public class UpdateSeedingController {

    private final UpdateSeedingInputBoundary updateSeedingUseCaseInteractor;
    private final SeedingState seedingState;

    public UpdateSeedingController(UpdateSeedingInputBoundary updateSeedingUseCaseInteractor, SeedingState seedingState) {
        this.updateSeedingUseCaseInteractor = updateSeedingUseCaseInteractor;
        this.seedingState = seedingState;
    }

    public void execute(int oldSeed, int newSeed) {

        int maxSeed = seedingState.getSeeding().size();
        final UpdateSeedingInputData updateSeedingInputData = new UpdateSeedingInputData(oldSeed, newSeed, maxSeed);

        updateSeedingUseCaseInteractor.execute(updateSeedingInputData);
    }
}