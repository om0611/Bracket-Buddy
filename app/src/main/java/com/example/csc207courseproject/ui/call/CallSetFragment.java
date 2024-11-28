package com.example.csc207courseproject.ui.call;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import com.example.csc207courseproject.databinding.FragmentCallSetBinding;
import com.example.csc207courseproject.interface_adapter.call_set.CallSetState;
import com.example.csc207courseproject.interface_adapter.upcoming_sets.UpcomingSetsController;
import com.example.csc207courseproject.ui.AppFragment;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CallSetFragment extends AppFragment implements PropertyChangeListener {

    private static CallViewModel callViewModel;
    private static UpcomingSetsController upcomingSetsController;

    private FragmentCallSetBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        callViewModel.addPropertyChangeListener(this);

        binding = FragmentCallSetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        CallSetState currentState = callViewModel.getState();

        TextView text = binding.selectedText;
        String outputText = currentState.getCurrentSet().toString()
                + "\n| Station 1 |";
        text.setText(outputText);

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        callViewModel.removePropertyChangeListener(this);
        binding = null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }


    public static void setUpcomingSetsController(UpcomingSetsController controller) {
        upcomingSetsController = controller;
    }
//
//    public static void setSelectPhaseController(SelectPhaseController controller) {
//        selectPhaseController = controller;
//    }
//
//    public static void setMutateSeedingController(MutateSeedingController controller) {
//        mutateSeedingController = controller;
//    }

    public static void setCallViewModel(CallViewModel viewModel) {
        callViewModel = viewModel;
    }
}
