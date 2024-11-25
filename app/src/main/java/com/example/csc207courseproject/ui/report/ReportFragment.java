package com.example.csc207courseproject.ui.report;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.csc207courseproject.R;
import com.example.csc207courseproject.databinding.FragmentReportBinding;
import com.example.csc207courseproject.interface_adapter.report_set.ReportSetState;
import com.example.csc207courseproject.ui.AppFragment;
import com.example.csc207courseproject.ui.call.CallViewModel;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class ReportFragment extends AppFragment implements PropertyChangeListener {

    private static ReportViewModel reportViewModel;
    private FragmentReportBinding binding;
    private NavController navc;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        reportViewModel.addPropertyChangeListener(this);

        binding = FragmentReportBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        createDisplay();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ReportSetFragment.setReportViewModel(reportViewModel);
        navc = Navigation.findNavController(view);
    }

    //TEST CODE DELETE LATER
    private void createDisplay() {
        ReportSetState currentState = reportViewModel.getState();
        List<String> setDisplay = new ArrayList<>();
        ListView setsView = binding.ongoingSets;
        //List<SetData> sets = currentState.getUpcomingSets();
        //if(sets != null) {
        for (int i = 0; i < 10; i++) {
            // setDisplay.add((i + 1) + ". " + sets.get(i).toString());
            setDisplay.add(String.valueOf(i) + "Gamer vs. Q");
        }
        //}
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, setDisplay);
        setsView.setAdapter(itemsAdapter);
        setsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> list, View view, int position, long id) {
                reportViewModel.getState().setSelectedSetIndex(position);
                navc.navigate(R.id.action_nav_report_to_reportSetFragment);

            }

        });
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

    public static void setReportViewModel(ReportViewModel viewModel) {reportViewModel = viewModel;}
}