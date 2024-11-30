package com.example.csc207courseproject.use_case.get_stations;


import android.util.Log;
import com.example.csc207courseproject.entities.EventData;

import java.util.Arrays;

public class GetStationsInteractor implements GetStationsInputBoundary {

    private final GetStationsOutputBoundary getStationsPresenter;
    private final GetStationsDataAccessInterface dataAccess;

    public GetStationsInteractor(GetStationsDataAccessInterface dataAccess,
                                 GetStationsOutputBoundary ongoingSetsPresenter) {
        this.dataAccess = dataAccess;
        this.getStationsPresenter = ongoingSetsPresenter;
    }

    @Override
    public void execute() {
        // Check if API call is successful
        int eventId = EventData.getEventId();
        try {
            GetStationsOutputData s = new GetStationsOutputData(dataAccess.getStations(eventId));

            getStationsPresenter.prepareSuccessView(s);
        } catch (Exception e) {
            getStationsPresenter.prepareFailView("Something went wrong with the API call, try again.");
        }
    }

}
