package com.example.csc207courseproject.interface_adapter.ongoing_sets;

import com.example.csc207courseproject.interface_adapter.ViewManagerModel;
import com.example.csc207courseproject.interface_adapter.call_set.CallSetState;
import com.example.csc207courseproject.interface_adapter.report_set.ReportSetState;
import com.example.csc207courseproject.ui.report.ReportViewModel;
import com.example.csc207courseproject.use_case.ongoing_sets.OngoingSetsOutputBoundary;
import com.example.csc207courseproject.use_case.ongoing_sets.OngoingSetsOutputData;

public class OngoingSetsPresenter implements OngoingSetsOutputBoundary {

    private final ReportViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    public OngoingSetsPresenter(ReportViewModel viewModel, ViewManagerModel viewManagerModel) {
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(OngoingSetsOutputData outputData) {
        final ReportSetState currentState = viewModel.getState();
        currentState.setOngoingSets(outputData.getOngoingSets());
        viewModel.firePropertyChanged("getsetssuccess");
    }

    @Override
    public void prepareFailView(String errorMessage) {
        viewModel.firePropertyChanged("getsetsfail");
    }

}
