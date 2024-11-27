package com.example.csc207courseproject.interface_adapter.upcoming_sets;

import com.example.csc207courseproject.interface_adapter.ViewManagerModel;
import com.example.csc207courseproject.interface_adapter.call_set.CallSetState;
import com.example.csc207courseproject.ui.call.CallViewModel;
import com.example.csc207courseproject.use_case.upcoming_sets.UpcomingSetsOutputBoundary;
import com.example.csc207courseproject.use_case.upcoming_sets.UpcomingSetsOutputData;

public class UpcomingSetsPresenter implements UpcomingSetsOutputBoundary {

    private final CallViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public UpcomingSetsPresenter(CallViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UpcomingSetsOutputData outputData) {
        final CallSetState setState = viewModel.getState();
        viewModel.firePropertyChanged("getsetssuccess");
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final CallSetState setState = viewModel.getState();
        viewModel.firePropertyChanged("getsetsfail");
    }

}
