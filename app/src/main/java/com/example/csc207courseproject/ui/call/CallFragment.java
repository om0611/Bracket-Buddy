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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.csc207courseproject.R;
import com.example.csc207courseproject.databinding.FragmentCallBinding;
import com.example.csc207courseproject.entities.SetData;
import com.example.csc207courseproject.interface_adapter.call_set.CallSetState;
import com.example.csc207courseproject.interface_adapter.upcoming_sets.UpcomingSetsController;
import com.example.csc207courseproject.ui.AppFragment;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class CallFragment extends AppFragment implements PropertyChangeListener {

    private static CallViewModel callViewModel;
    private static UpcomingSetsController upcomingSetsController;
    private NavController navc;

    private FragmentCallBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        callViewModel.addPropertyChangeListener(this);

        binding = FragmentCallBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        upcomingSetsController.execute();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CallSetFragment.setCallViewModel(callViewModel);
        navc = Navigation.findNavController(view);
    }

    //TEST CODE DELETE LATER
    private void createDisplay() {
        CallSetState currentState = callViewModel.getState();
        List<String> setDisplay = new ArrayList<>();
        ListView setsView = binding.upcomingSets;
        List<SetData> sets = currentState.getUpcomingSets();
        if(sets != null) {
            for (SetData set : sets) {
                setDisplay.add(set.toString());
            }
        }
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, setDisplay);
        setsView.setAdapter(itemsAdapter);
        setsView.setOnItemClickListener((list, view, position, id) -> {
            callViewModel.getState().setSelectedSetIndex(position);
            navc.navigate(R.id.action_nav_call_to_callSetFragment);

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "getsetssuccess": createDisplay(); break;
            case "getsetsfail": break;
        }
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