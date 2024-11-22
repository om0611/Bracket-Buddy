package com.example.csc207courseproject.interface_adapter.report_game;

import com.example.csc207courseproject.interface_adapter.ViewManagerModel;
import com.example.csc207courseproject.interface_adapter.update_seeding.SeedingState;
import com.example.csc207courseproject.ui.report.ReportViewModel;
import com.example.csc207courseproject.ui.seeding.SeedingViewModel;
import com.example.csc207courseproject.use_case.report_game.ReportGameOutputBoundary;
import com.example.csc207courseproject.use_case.report_game.ReportGameOutputData;

public class ReportGamePresenter implements ReportGameOutputBoundary {

    private final ReportViewModel gameViewModel;
    private final ViewManagerModel viewManagerModel;

    public ReportGamePresenter(ReportViewModel gameViewModel, ViewManagerModel viewManagerModel) {
        this.gameViewModel = gameViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ReportGameOutputData outputData) {
//        final SeedingState setState = gameViewModel.getState();
//        gameViewModel.firePropertyChanged("updatesuccess");
    }

    @Override
    public void prepareFailView(String errorMessage) {
//        final SeedingState seedingState = gameViewModel.getState();
//        seedingState.setError(errorMessage);
//        gameViewModel.firePropertyChanged("updatefail");
    }

}
