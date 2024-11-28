package com.example.csc207courseproject.interface_adapter.get_stations;

import com.example.csc207courseproject.interface_adapter.call_set.CallSetState;
import com.example.csc207courseproject.use_case.get_stations.GetStationsInputBoundary;

public class GetStationsController {
    private final GetStationsInputBoundary getStationsUseCaseInteractor;

    public GetStationsController(GetStationsInputBoundary getStationsUseCaseInteractor) {
        this.getStationsUseCaseInteractor = getStationsUseCaseInteractor;
    }


    /**
     * Execute the get stations use case
     */
    public void execute() {
        getStationsUseCaseInteractor.execute();

    }
}
