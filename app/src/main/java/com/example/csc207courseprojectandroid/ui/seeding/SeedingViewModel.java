package com.example.csc207courseprojectandroid.ui.seeding;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.csc207courseprojectandroid.interface_adapter.ViewModel;
import com.example.csc207courseprojectandroid.interface_adapter.update_seeding.SeedingState;

public class SeedingViewModel extends ViewModel<SeedingState> {

    public SeedingViewModel() {
        super("seeding");
        setState(new SeedingState());
    }

}