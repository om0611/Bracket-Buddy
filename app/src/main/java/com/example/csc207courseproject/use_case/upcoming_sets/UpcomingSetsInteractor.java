package com.example.csc207courseproject.use_case.upcoming_sets;


import android.util.Log;
import com.example.csc207courseproject.entities.EventData;

import java.util.Arrays;

public class UpcomingSetsInteractor implements UpcomingSetsInputBoundary {

    private final UpcomingSetsOutputBoundary upcomingSetsPresenter;
    private final UpcomingSetsDataAccessInterface dataAccess;

    public UpcomingSetsInteractor(UpcomingSetsDataAccessInterface dataAccess,
                                  UpcomingSetsOutputBoundary upcomingSetsPresenter) {
        this.dataAccess = dataAccess;
        this.upcomingSetsPresenter = upcomingSetsPresenter;
    }

    @Override
    public void execute() {
        // Check if API call is successful
        int eventId = EventData.getEventId();
        try {
            UpcomingSetsOutputData s = new UpcomingSetsOutputData(dataAccess.getUpcomingSets(eventId));

            upcomingSetsPresenter.prepareSuccessView(s);
        } catch (Exception e) {
            //Log.d("EXCEPTION", e.toString());
            upcomingSetsPresenter.prepareFailView("Something went wrong with the API call, try again.");
        }
    }

}
