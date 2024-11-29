
package com.example.csc207courseproject.interface_adapter.report_set;

import com.example.csc207courseproject.interface_adapter.ViewManagerModel;
import com.example.csc207courseproject.interface_adapter.report_set.ReportSetState;
import com.example.csc207courseproject.ui.report.ReportViewModel;
import com.example.csc207courseproject.use_case.report_set.ReportSetOutputBoundary;

public class ReportSetPresenter implements ReportSetOutputBoundary {

    private final ReportViewModel reportViewModel;
    private final ViewManagerModel viewManagerModel;

    public ReportSetPresenter(ReportViewModel reportViewModel, ViewManagerModel viewManagerModel) {
        this.reportViewModel = reportViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        int reportedID = reportViewModel.getState().getCurrentSet().getSetID();
        reportViewModel.getState().addReportedSetID(reportedID);
        reportViewModel.firePropertyChanged("reportsetsuccess");

    }

    @Override
    public void prepareFailView(String errorMessage) {
        reportViewModel.firePropertyChanged(errorMessage);
    }
}
