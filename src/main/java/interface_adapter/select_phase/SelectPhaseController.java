package interface_adapter.select_phase;

import use_case.select_phase.SelectPhaseInputBoundary;
import use_case.select_phase.SelectPhaseInputData;
import interface_adapter.update_seeding.SeedingState;

/**
 * The controller for the Select Phase Use case
 */
public class SelectPhaseController {

    private final SelectPhaseInputBoundary selectphaseUseCaseInteractor;
    private final SeedingState seedingState;

    public SelectPhaseController(SelectPhaseInputBoundary selectphaseUseCaseInteractor, SeedingState seedingState) {
        this.selectphaseUseCaseInteractor = selectphaseUseCaseInteractor;
        this.seedingState = seedingState;
    }

    /**
     * Execute the Select Phase use case
     */
    public void execute(String selectedPhase) {

        int phaseID = seedingState.phaseNametoId(selectedPhase);
        final SelectPhaseInputData selectPhaseInputData = new SelectPhaseInputData(phaseID);

        selectphaseUseCaseInteractor.execute(selectPhaseInputData);
    }
}
