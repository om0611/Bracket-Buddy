package use_case.update_seeding;

import data_access.APIDataAccessObject;
import use_case.select_phase.SelectPhaseInteractor;
import use_case.select_phase.SelectPhaseOutputBoundary;
import use_case.select_phase.SelectPhaseOutputData;

public class UpdateSeedingInteractor implements UpdateSeedingInputBoundary {
    private final APIDataAccessObject dataAccess;
    private final UpdateSeedingOutputBoundary updateSeedingPresenter;


    public UpdateSeedingInteractor(APIDataAccessObject dataAccess, UpdateSeedingOutputBoundary updateSeedingPresenter) {
        this.dataAccess = dataAccess;
        this.updateSeedingPresenter = updateSeedingPresenter;
    }

    @Override
    public void execute(UpdateSeedingInputData updateSeedingInputData) {
        int oldSeed = updateSeedingInputData.getOldSeed();
        int newSeed = updateSeedingInputData.getNewSeed();
        int maxSeed = updateSeedingInputData.getMaxSeed();

        if (oldSeed < 0 || newSeed < 0 || oldSeed > maxSeed || newSeed > maxSeed) {
            updateSeedingPresenter.prepareFailureView("These are not valid seeds.");
        }

        UpdateSeedingOutputData s = new UpdateSeedingOutputData(oldSeed, newSeed);
        updateSeedingPresenter.prepareSuccessView(s);
    }
}
