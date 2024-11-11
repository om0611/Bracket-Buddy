package use_case.update_seeding;

import data_access.APIDataAccessObject;

public class UpdateSeedingInteractor implements UpdateSeedingInputBoundary {
    private final APIDataAccessObject dataAccess;
    private final UpdateSeedingOutputBoundary updateSeedingPresenter;


    public UpdateSeedingInteractor(APIDataAccessObject dataAccess, UpdateSeedingOutputBoundary updateSeedingPresenter) {
        this.dataAccess = dataAccess;
        this.updateSeedingPresenter = updateSeedingPresenter;
    }

    @Override
    public void execute(UpdateSeedingInputData updateSeedingInputData) {
        String oldSeed = updateSeedingInputData.getOldSeed();
        String newSeed = updateSeedingInputData.getNewSeed();
        int maxSeed = updateSeedingInputData.getMaxSeed();
        try{
            Integer.parseInt(oldSeed);
            Integer.parseInt(newSeed);
        }catch (NumberFormatException e){
            updateSeedingPresenter.prepareFailView("These are not valid seeds.");
            return;
        }
        int oldSeedValue = Integer.parseInt(oldSeed);
        int newSeedValue = Integer.parseInt(newSeed);
        if (oldSeedValue <= 0 || newSeedValue <= 0 || oldSeedValue > maxSeed || newSeedValue > maxSeed) {
            updateSeedingPresenter.prepareFailView("These are not valid seeds.");
            return;
        }else {
            UpdateSeedingOutputData s = new UpdateSeedingOutputData(oldSeedValue, newSeedValue);
            updateSeedingPresenter.prepareSuccessView(s);
        }
    }
}
