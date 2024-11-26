package com.example.csc207courseproject.ui.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.csc207courseproject.databinding.FragmentReportSetBinding;
import com.example.csc207courseproject.interface_adapter.report_set.ReportSetState;
import com.example.csc207courseproject.ui.AppFragment;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReportSetFragment extends AppFragment implements PropertyChangeListener {

    private static ReportViewModel reportViewModel;

    private FragmentReportSetBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reportViewModel.addPropertyChangeListener(this);

        binding = FragmentReportSetBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        ReportSetState currentState = reportViewModel.getState();


        TextView text = binding.playersTitle;
        //Does this need to be an entire api call?
        text.setText(currentState.getOngoingSets().get(currentState.getSelectedSetIndex()).toString());

        // upcomingSetsController.execute();

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

    public static void setReportViewModel(ReportViewModel viewModel) {
        reportViewModel = viewModel;
    }
}
