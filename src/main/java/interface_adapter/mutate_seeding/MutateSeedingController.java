package interface_adapter.mutate_seeding;

import use_case.mutate_seeding.MutateSeedingInputData;
import use_case.mutate_seeding.MutateSeedingInputBoundary;
import interface_adapter.update_seeding.SeedingState;

import java.util.List;

/**
 * The controller for the Select Phase Use case
 */
public class SelectPhaseController {

    private final MutateSeedingInputBoundary mutateSeedingUseCaseInteractor;
    private final SeedingState seedingState;

    public SelectPhaseController(MutateSeedingInputBoundary mutateSeedingUseCaseInteractor, SeedingState seedingState) {
        this.mutateSeedingUseCaseInteractor = mutateSeedingUseCaseInteractor;
        this.seedingState = seedingState;
    }

    /**
     * Execute the Select Phase use case
     */
    public void execute(String selectedPhase) {

        int phaseID = seedingState.phaseNametoId(selectedPhase);
        List<Integer> seeding = seedingState.getSeeding();
        final MutateSeedingInputData selectPhaseInputData = new MutateSeedingInputData(phaseID, seeding);

        mutateSeedingUseCaseInteractor.execute(selectPhaseInputData);
    }
}

