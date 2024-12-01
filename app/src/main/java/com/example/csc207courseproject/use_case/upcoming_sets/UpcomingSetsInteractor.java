package com.example.csc207courseproject.use_case.upcoming_sets;


import android.security.identity.AlreadyPersonalizedException;
import android.util.Log;
import com.example.csc207courseproject.data_access.api.APIDataAccessException;
import com.example.csc207courseproject.entities.Entrant;
import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.SetData;

import java.util.Arrays;
import java.util.List;

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
            List<SetData> upcomingSets = dataAccess.getUpcomingSets(eventId);

            //Reopen free stations
            for (SetData upcomingSet : upcomingSets) {
                for(Entrant entrant : upcomingSet.getPlayers()) {
                    if (entrant.getCurrentStation() != null) {
                        entrant.getCurrentStation().setOccupied(false);
                    }
                }
            }

            UpcomingSetsOutputData s = new UpcomingSetsOutputData(dataAccess.getUpcomingSets(eventId));

            upcomingSetsPresenter.prepareSuccessView(s);
        } catch (APIDataAccessException e) {
            upcomingSetsPresenter.prepareFailView("Something went wrong with the API call, try again.");
        }
    }

}