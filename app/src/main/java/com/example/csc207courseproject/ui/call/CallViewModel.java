package com.example.csc207courseproject.ui.call;

import com.example.csc207courseproject.interface_adapter.ViewModel;
import com.example.csc207courseproject.interface_adapter.call_set.CallSetState;
import com.example.csc207courseproject.interface_adapter.update_seeding.SeedingState;

public class CallViewModel extends ViewModel<CallSetState> {


    public CallViewModel() {
        super("callSet");
        setState(new CallSetState());
    }
}