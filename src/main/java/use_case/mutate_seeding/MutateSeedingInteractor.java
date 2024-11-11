package use_case.mutate_seeding;

import data_access.APIDataAccessObject;
import java.util.List;

public class MutateSeedingInteractor implements MutateSeedingInputBoundary {

    private final APIDataAccessObject dataAccess;
    private final MutateSeedingOutputBoundary mutateSeedingPresenter;

    public MutateSeedingInteractor(APIDataAccessObject dataAccess, MutateSeedingOutputBoundary mutateSeedingPresenter) {
        this.dataAccess = dataAccess;
        this.mutateSeedingPresenter = mutateSeedingPresenter;
    }

    @Override
    public void execute(MutateSeedingInputData mutateSeedingInputData) {
        int phaseID = mutateSeedingInputData.getPhaseID();
        List<Integer> finalSeeds = mutateSeedingInputData.getFinalSeeds();

        try {
            dataAccess.setSeeding(finalSeeds, phaseID);
            mutateSeedingPresenter.prepareSuccessView();
        } catch (Exception e) {
            selectPhasePresenter.prepareFailureView("Something went wrong with the API call, try again kiddo.");
        }
    }

    @Override
    public void switchToMainView() {
        mutateSeedingPresenter.switchToMainView();
    }

}
