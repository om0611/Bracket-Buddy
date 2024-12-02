package com.example.csc207courseproject.interface_adapter.export_finance;

import android.content.Context;

import com.example.csc207courseproject.use_case.export_finance.ExportFinanceInputBoundary;
import com.example.csc207courseproject.use_case.export_finance.ExportFinanceInputData;
import com.example.csc207courseproject.use_case.modify_finance.ModifyFinanceInputBoundary;
import com.example.csc207courseproject.use_case.modify_finance.ModifyFinanceInputData;
import com.example.csc207courseproject.interface_adapter.get_finance.GetFinanceState;

import java.io.File;

public class ExportFinanceController {
    private final ExportFinanceInputBoundary interactor;

    private final GetFinanceState state;

    /**
     * Construct a new ExportFinanceController with the given interactor and state.
     *
     * @param interactor the interactor for the export finance use case.
     * @param state the state for the export finance use case.
     */
    public ExportFinanceController(ExportFinanceInputBoundary interactor, GetFinanceState state) {
        this.interactor = interactor;
        this.state = state;
    }

    /**
     * Execute the logic for the export finance use case.
     *
     * @param context the context for the export finance use case.
     */
    public void execute(Context context) {
        File file = new File(context.getFilesDir(), "participant_payment_status.csv");
        ExportFinanceInputData inputData = new ExportFinanceInputData(file);
        interactor.execute(inputData);
    }
}
