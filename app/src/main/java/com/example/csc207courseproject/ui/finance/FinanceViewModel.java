package com.example.csc207courseproject.ui.finance;

import com.example.csc207courseproject.interface_adapter.ViewModel;
import com.example.csc207courseproject.interface_adapter.get_finance.GetFinanceState;

public class FinanceViewModel extends ViewModel<GetFinanceState> {
    public FinanceViewModel() {
        super("finance");
        setState(new GetFinanceState());
    }
}
