package com.example.csc207courseproject.interface_adapter.get_finance;

import com.example.csc207courseproject.use_case.get_finance.GetFinanceInputBoundary;
import com.example.csc207courseproject.use_case.get_finance.GetFinanceInputData;

public class GetFinanceController {
    private final GetFinanceInputBoundary interactor;

    private final GetFinanceState state;

    /**
     * Construct a new GetFinanceController with the given interactor and state.
     *
     * @param interactor the interactor for the get finance use case.
     * @param state the state for the get finance use case.
     */

    public GetFinanceController(GetFinanceInputBoundary interactor, GetFinanceState state) {
        this.interactor = interactor;
        this.state = state;
    }

    /**
     * Execute the logic for the get finance use case.
     */
    public void execute() {
        GetFinanceInputData inputData = new GetFinanceInputData(state.getEventID());

        interactor.execute(inputData);
    }
}
