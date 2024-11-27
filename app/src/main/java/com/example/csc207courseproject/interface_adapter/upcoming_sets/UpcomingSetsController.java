package com.example.csc207courseproject.interface_adapter.upcoming_sets;

import com.example.csc207courseproject.interface_adapter.call_set.CallSetState;
import com.example.csc207courseproject.use_case.upcoming_sets.UpcomingSetsInputBoundary;

public class UpcomingSetsController {
    private final UpcomingSetsInputBoundary upcomingSetsUseCaseInteractor;
    private final CallSetState setState;

    public UpcomingSetsController(UpcomingSetsInputBoundary upcomingSetsUseCaseInteractor, CallSetState setState) {
        this.upcomingSetsUseCaseInteractor = upcomingSetsUseCaseInteractor;
        this.setState = setState;
    }


    /**
     * Execute the report game use case
     */
    public void execute(String selectedPhase) {
        upcomingSetsUseCaseInteractor.execute();

    }
}
