package com.example.csc207courseproject.ui.call;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import com.example.csc207courseproject.databinding.FragmentCallBinding;
import com.example.csc207courseproject.entities.SetData;
import com.example.csc207courseproject.interface_adapter.call_set.CallSetState;
import com.example.csc207courseproject.interface_adapter.mutate_seeding.MutateSeedingController;
import com.example.csc207courseproject.interface_adapter.select_phase.SelectPhaseController;
import com.example.csc207courseproject.interface_adapter.update_seeding.SeedingState;
import com.example.csc207courseproject.interface_adapter.update_seeding.UpdateSeedingController;
import com.example.csc207courseproject.ui.AppFragment;
import com.example.csc207courseproject.ui.seeding.SeedingViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class CallFragment extends AppFragment implements PropertyChangeListener {

    private static CallViewModel callViewModel;

private FragmentCallBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        callViewModel.addPropertyChangeListener(this);

        binding = FragmentCallBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        createDisplay();

        return root;
    }

    //TEST CODE DELETE LATER
    private void createDisplay() {
        CallSetState currentState = callViewModel.getState();
        List<String> setDisplay = new ArrayList<>();
        ListView setsView = binding.upcomingSets;
        List<SetData> sets = currentState.getUpcomingSets();
        if(sets != null) {
            for (int i = 0; i < sets.size(); i++) {
                setDisplay.add((i + 1) + ". " + sets.get(i).toString());
            }
        }
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, setDisplay);
        setsView.setAdapter(itemsAdapter);
        setsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int position, long id) {
                showToast(setDisplay.get(position));

            }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

//    public static void setUpdateSeedingController(UpdateSeedingController controller) {
//        updateSeedingController = controller;
//    }
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