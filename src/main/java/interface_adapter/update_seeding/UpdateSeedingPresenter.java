package interface_adapter.update_seeding;

import interface_adapter.ViewManagerModel;
import use_case.update_seeding.UpdateSeedingOutputBoundary;
import use_case.update_seeding.UpdateSeedingOutputData;

public class UpdateSeedingPresenter implements UpdateSeedingOutputBoundary {

    private final SeedingViewModel seedingViewModel;
    private final ViewManagerModel viewManagerModel;

    public UpdateSeedingPresenter(SeedingViewModel seedingViewModel, ViewManagerModel viewManagerModel) {
        this.seedingViewModel = seedingViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UpdateSeedingOutputData outputData) {
        final SeedingState seedingState = seedingViewModel.getState();
        final int oldSeed = outputData.getOldSeed();
        final int newSeed = outputData.getNewSeed();
        seedingState.moveSeed(oldSeed, newSeed);
        seedingViewModel.firePropertyChanged("updatesuccess");
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final SeedingState seedingState = seedingViewModel.getState();
        seedingState.setError(errorMessage);
        seedingViewModel.firePropertyChanged("updatefail");
    }
}
