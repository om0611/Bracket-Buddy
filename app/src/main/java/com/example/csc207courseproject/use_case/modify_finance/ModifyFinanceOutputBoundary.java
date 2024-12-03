package com.example.csc207courseproject.use_case.modify_finance;

import com.example.csc207courseproject.use_case.call_set.CallSetOutputData;

public interface ModifyFinanceOutputBoundary {
    void prepareSuccessView(ModifyFinanceOutputData outputData);


    void prepareFailView();
}
