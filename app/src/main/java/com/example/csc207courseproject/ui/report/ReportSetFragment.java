package com.example.csc207courseproject.ui.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.csc207courseproject.databinding.FragmentReportSetBinding;
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

        TextView text = binding.textMini;
        text.setText(reportViewModel.getState().getSelectedSetIndex() + "");

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
