package com.example.csc207courseprojectandroid.use_case.select_phase;

/**
 * Input Boundary for actions which are related to updating seeding locally for the display.
 */

public interface SelectPhaseInputBoundary {
    /**
     * Executes the update seeding to Start.gg case.
     * @param selectPhaseInputData the input data
     */
    void execute(SelectPhaseInputData selectPhaseInputData);

}
