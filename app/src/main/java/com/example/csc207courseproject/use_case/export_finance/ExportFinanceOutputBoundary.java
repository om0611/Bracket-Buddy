package com.example.csc207courseproject.use_case.export_finance;

import com.example.csc207courseproject.use_case.call_set.CallSetOutputData;
import com.example.csc207courseproject.use_case.export_finance.ExportFinanceOutputData;

public interface ExportFinanceOutputBoundary {
    void prepareSuccessView(ExportFinanceOutputData outputData);


    void prepareFailView();
}
