package com.example.csc207courseproject.use_case.get_finance;

import com.example.csc207courseproject.use_case.call_set.CallSetOutputData;

public interface GetFinanceOutputBoundary {
    void prepareSuccessView(GetFinanceOutputData outputData);


    void prepareFailView();
}
