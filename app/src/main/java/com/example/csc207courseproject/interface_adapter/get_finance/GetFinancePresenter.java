package com.example.csc207courseproject.interface_adapter.get_finance;

import com.example.csc207courseproject.ui.finance.FinanceViewModel;
import com.example.csc207courseproject.use_case.get_finance.GetFinanceOutputBoundary;
import com.example.csc207courseproject.use_case.get_finance.GetFinanceOutputData;

import java.util.List;

public class GetFinancePresenter implements GetFinanceOutputBoundary {

    private final FinanceViewModel viewModel;

    /**
     * Construct a new GetFinancePresenter with the given view model.
     *
     * @param viewModel the view model for the get finance use case.
     */
    public GetFinancePresenter(FinanceViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Prepare the success view for the get finance use case.
     *
     * @param outputData the output data for the get finance use case.
     */
    @Override
    public void prepareSuccessView(GetFinanceOutputData outputData) {
        GetFinanceState currentState = viewModel.getState();
        List<String> paymentStatuses = outputData.getFinanceEntries();
        currentState.setPartcipantPaymentStatus(paymentStatuses);
        viewModel.firePropertyChanged("fetchSuccess");
    }

    /**
     * Prepare the fail view for the get finance use case.
     */
    @Override
    public void prepareFailView() {
        viewModel.firePropertyChanged("fetchFailure");
    }
}
