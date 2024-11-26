
package com.example.csc207courseproject.interface_adapter.report_set;

import com.example.csc207courseproject.interface_adapter.ViewManagerModel;
import com.example.csc207courseproject.ui.report.ReportViewModel;
import com.example.csc207courseproject.ui.report.SelectSetToReportViewModel;
import com.example.csc207courseproject.use_case.report_set.ReportSetOutputBoundary;

public class ReportSetPresenter implements ReportSetOutputBoundary {

    private final SelectSetToReportViewModel selectSetToReportViewModel;
    private final ReportViewModel reportViewModel;
    private final ViewManagerModel viewManagerModel;

    public ReportSetPresenter(SelectSetToReportViewModel selectSetToReportViewModel, ReportViewModel reportViewModel, ViewManagerModel viewManagerModel) {
        this.selectSetToReportViewModel = selectSetToReportViewModel;
        this.reportViewModel = reportViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
//        reportViewModel.firePropertyChanged("mutatesuccess");
//
//        this.viewManagerModel.setState(loggedInViewModel.getViewName());
//        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
//        seedingState.setError(errorMessage);
//        seedingViewModel.firePropertyChanged("mutatefail");
        // Add a thing for fire to update the ongoing sets
    }
}
