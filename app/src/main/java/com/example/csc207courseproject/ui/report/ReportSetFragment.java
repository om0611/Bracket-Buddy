package com.example.csc207courseproject.ui.report;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.csc207courseproject.databinding.FragmentReportSetBinding;
import com.example.csc207courseproject.interface_adapter.report_set.ReportSetController;
import com.example.csc207courseproject.interface_adapter.report_set.ReportSetState;
import com.example.csc207courseproject.ui.AppFragment;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReportSetFragment extends AppFragment implements PropertyChangeListener {

    private static ReportViewModel reportViewModel;

    private static ReportSetController reportSetController;

    private NavController navController;

    private FragmentReportSetBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        reportViewModel.addPropertyChangeListener(this);
        binding = FragmentReportSetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ReportSetState currentState = reportViewModel.getState();


        TextView text = binding.playersTitle;
        text.setText(currentState.getCurrentSet().toString());

        createMutateButton();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "reportsetsuccess":
                showToast("The set has been reported to Start.gg!");
                navController.navigateUp();
                break;
            case "reportsetsfail": showToast("We can't reach Start.gg right now :("); break;
        }
    }

    public static void setReportSetController(ReportSetController controller) {
        reportSetController = controller;
    }

    public static void setReportViewModel(ReportViewModel viewModel) {
        reportViewModel = viewModel;
    }

    //Function for the report to start.gg option
    private void createMutateButton(){
        Button mutateSetButton = binding.mutateSetButton;
        mutateSetButton.setOnClickListener(view -> reportSetController.execute(
                binding.isP1DQ.isChecked(), binding.isP2DQ.isChecked()));
    }
}
