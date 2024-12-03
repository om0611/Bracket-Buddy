package com.example.csc207courseproject.interface_adapter.modify_finance;

import com.example.csc207courseproject.ui.finance.FinanceViewModel;
import com.example.csc207courseproject.use_case.modify_finance.ModifyFinanceOutputBoundary;
import com.example.csc207courseproject.use_case.modify_finance.ModifyFinanceOutputData;
import com.example.csc207courseproject.interface_adapter.get_finance.GetFinanceState;

import java.util.List;

public class ModifyFinancePresenter implements ModifyFinanceOutputBoundary {

    private final FinanceViewModel viewModel;

    /**
     * Construct a new ModifyFinancePresenter with the given view model.
     *
     * @param viewModel the view model for the modify finance use case.
     */
    public ModifyFinancePresenter(FinanceViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Prepare the success view for the modify finance use case.
     *
     * @param outputData the output data for the modify finance use case.
     */
    @Override
    public void prepareSuccessView(ModifyFinanceOutputData outputData) {
        GetFinanceState currentState = viewModel.getState();
        currentState.setPartcipantPaymentStatus(outputData.getUpdatedPaymentStatuses());
        currentState.setFinancialEntries(outputData.getUpdatedPaymentStatuses());
        
        viewModel.firePropertyChanged("updateSuccess");
    }

    /**
     * Prepare the fail view for the modify finance use case.
     */
    @Override
    public void prepareFailView() {
        viewModel.firePropertyChanged("updateFail");
    }
}
