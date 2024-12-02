package com.example.csc207courseproject.interface_adapter.export_finance;

import com.example.csc207courseproject.ui.finance.FinanceViewModel;
import com.example.csc207courseproject.use_case.export_finance.ExportFinanceOutputBoundary;
import com.example.csc207courseproject.use_case.export_finance.ExportFinanceOutputData;
import com.example.csc207courseproject.interface_adapter.get_finance.GetFinanceState;

import java.util.List;

public class ExportFinancePresenter implements ExportFinanceOutputBoundary {

    private final FinanceViewModel viewModel;

    /**
     * Construct a new ExportFinancePresenter with the given view model.
     *
     * @param viewModel the view model for the export finance use case.
     */
    public ExportFinancePresenter(FinanceViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Prepare the success view for the export finance use case.
     *
     * @param outputData the output data for the export finance use case.
     */
    @Override
    public void prepareSuccessView(ExportFinanceOutputData outputData) {
        viewModel.firePropertyChanged("exportSuccess");
    }

    /**
     * Prepare the fail view for the export finance use case.
     */
    @Override
    public void prepareFailView() {
        viewModel.firePropertyChanged("exportFail");
    }
}
