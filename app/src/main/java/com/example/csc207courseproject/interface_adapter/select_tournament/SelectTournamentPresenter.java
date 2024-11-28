package com.example.csc207courseproject.interface_adapter.select_tournament;

import com.example.csc207courseproject.interface_adapter.ViewManagerModel;
import com.example.csc207courseproject.interface_adapter.select_event.EventState;
import com.example.csc207courseproject.interface_adapter.select_event.SelectEventViewModel;
import com.example.csc207courseproject.use_case.select_tournament.SelectTournamentOutputBoundary;
import com.example.csc207courseproject.use_case.select_tournament.SelectTournamentOutputData;

public class SelectTournamentPresenter implements SelectTournamentOutputBoundary {

    private final SelectTournamentViewModel selectTournamentViewModel;
    private final ViewManagerModel viewManagerModel;
    private final SelectEventViewModel selectEventViewModel;

    public SelectTournamentPresenter(SelectTournamentViewModel selectTournamentViewModel,
                                     ViewManagerModel viewManagerModel,
                                     SelectEventViewModel selectEventViewModel) {
        this.selectTournamentViewModel = selectTournamentViewModel;
        this.viewManagerModel = viewManagerModel;
        this.selectEventViewModel = selectEventViewModel;
    }

    @Override
    public void prepareSuccessView(SelectTournamentOutputData selectTournamentOutputData) {
        final EventState eventState = selectEventViewModel.getState();
        eventState.setEventNames(selectTournamentOutputData.getEventNames());
        eventState.setEventIds(selectTournamentOutputData.getEventIds());
        selectTournamentViewModel.firePropertyChanged("tournamentsuccess");
    }

    @Override
    public void prepareFailView() {
        selectTournamentViewModel.firePropertyChanged("tournamentfail");
    }
}
