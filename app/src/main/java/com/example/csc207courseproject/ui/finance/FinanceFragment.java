package com.example.csc207courseproject.ui.finance;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;


import com.example.csc207courseproject.databinding.FragmentFinanceBinding;
import com.example.csc207courseproject.databinding.PlayerFinancePopupBinding;

import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.interface_adapter.export_finance.ExportFinanceController;
import com.example.csc207courseproject.interface_adapter.get_finance.GetFinanceController;
import com.example.csc207courseproject.interface_adapter.get_finance.GetFinanceState;
import com.example.csc207courseproject.ui.AppFragment;
import com.example.csc207courseproject.interface_adapter.modify_finance.ModifyFinanceController;
import org.jetbrains.annotations.NotNull;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class FinanceFragment extends AppFragment implements PropertyChangeListener {

    private FragmentFinanceBinding binding;
    private static FinanceViewModel financeViewModel;
    private static GetFinanceController getFinanceController;
    private static ModifyFinanceController modifyFinanceController;
    private static ExportFinanceController exportFinanceController;
    private Context mContext;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Set up ViewModel
        financeViewModel.addPropertyChangeListener(this);

        binding = FragmentFinanceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        GetFinanceState currentState = financeViewModel.getState();
        int eventID = EventData.getEventData().getEventId();
        currentState.setEventID(eventID);

        getFinanceController.execute();
        List<String> statuses = createFinancialEntries();
        currentState.setFinancialEntries(statuses);
        observeFinancialEntries();

        binding.exportButton.setOnClickListener(v -> exportFinanceController.execute(requireContext()));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FinanceFragment.setFinanceViewModel(financeViewModel);

    }

    private List<String> createFinancialEntries() {

        GetFinanceState currentState = financeViewModel.getState();
        ListView financialListView = binding.seedsList;
        List<String> paymentStatuses = currentState.getPartcipantPaymentStatus();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, paymentStatuses);
        financialListView.setAdapter(adapter);
        return paymentStatuses;
    }

    private void observeFinancialEntries() {
        ListView financialListView = binding.seedsList;

        GetFinanceState state = financeViewModel.getState();

        LiveData<List<String>> items = state.getFinancialEntries();
        // Observe LiveData from the ViewModel
        state.getFinancialEntries().observe(getViewLifecycleOwner(), entries -> {
            if (entries != null) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(mContext, android.R.layout.simple_list_item_1, entries);
                financialListView.setAdapter(adapter);

                // Set item click listener to show popup
                financialListView.setOnItemClickListener((parent, view, position, id) -> {
                    String selectedEntry = entries.get(position);
                    showPlayerFinancePopup(selectedEntry);
                });
            }
        });
    }

    private void showPlayerFinancePopup(String playerInfo) {
        // Inflate custom popup layout
        PlayerFinancePopupBinding popupBinding = PlayerFinancePopupBinding.inflate(LayoutInflater.from(mContext));

        // Pre-fill data if necessary (e.g., player name)
        popupBinding.popupTitle.setText(String.format("Finances Updater For (%s)", playerInfo));

        // Build the AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setView(popupBinding.getRoot())
                .setPositiveButton("Update", (dialog, which) -> {
                    String cashAmount = popupBinding.cashInput.getText().toString();
                    String eTransferAmount = popupBinding.eTransferInput.getText().toString();
                    String specialNote = popupBinding.specialNotesInput.getText().toString();

                    GetFinanceState state = financeViewModel.getState();
                    state.setCashAmount(cashAmount);
                    state.seteTransferAmount(eTransferAmount);
                    state.setSpecialNote(specialNote);
                    state.setParticipantID(playerInfo);
                    modifyFinanceController.execute();
                })
                .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                .create()
                .show();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        financeViewModel.removePropertyChangeListener(this);
        binding = null;
    }

    public static void setFinanceViewModel(FinanceViewModel viewModel) {
        financeViewModel = viewModel;
    }

    public static void setGetFinanceController(GetFinanceController controller) {
        getFinanceController = controller;
    }

    public static void setModifyFinanceController(ModifyFinanceController controller) {
        modifyFinanceController = controller;
    }

    public static void setExportFinanceController(ExportFinanceController controller) {
        exportFinanceController = controller;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        switch (evt.getPropertyName()) {
            case "updateSuccess":
                Toast.makeText(mContext, "Payment status updated successfully.", Toast.LENGTH_SHORT).show();
                break;
            case "updateFail":
                Toast.makeText(mContext, "Failed to update payment status.", Toast.LENGTH_SHORT).show();
                break;
            case "exportSuccess":
                Toast.makeText(mContext, "Data exported successfully.", Toast.LENGTH_SHORT).show();
                break;
            case "exportFail":
                Toast.makeText(mContext, "Failed to export data.", Toast.LENGTH_SHORT).show();
                break;
            case "fetchSuccess":
                Toast.makeText(mContext, "Successfully fetched the payment statuses.", Toast.LENGTH_SHORT).show();
                break;
            case "fetchFailure":
                Toast.makeText(mContext, "Failed to fetch the payment statuses.", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}