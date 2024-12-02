package com.example.csc207courseproject.use_case.export_finance;

import android.annotation.SuppressLint;

import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Participant;
import com.example.csc207courseproject.entities.Station;
import com.example.csc207courseproject.use_case.call_set.CallSetOutputData;
import com.example.csc207courseproject.use_case.export_finance.ExportFinanceOutputData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExportFinanceInteractor implements ExportFinanceInputBoundary {

    private final ExportFinanceDataAccessInterface dataAccess;
    private final ExportFinanceOutputBoundary presenter;

    /**
     * Construct a new ExportFinanceInteractor with the given data access and presenter.
     *
     * @param dataAccess the data access interface.
     * @param presenter the output boundary.
     */
    public ExportFinanceInteractor(ExportFinanceDataAccessInterface dataAccess, ExportFinanceOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    /**
     * Execute the logic for the modify finance use case.
     * @param inputData The input data containing event information
     */
    @Override
    public void execute(ExportFinanceInputData inputData) {
        File file = inputData.file;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            Map<Integer, Participant> participantPaymentStatus = dataAccess.getParticipantPaymentStatus();
            // Write the header of the CSV file
            writer.write("Name,Status,CashPaid,eTransferPaid,SpecialNotes");
            writer.newLine();

            // Iterate through the participantPaymentStatus HashMap and write data to the CSV file
            for (Participant participant : participantPaymentStatus.values()) {
                String name = participant.getName();
                String status = participant.isPaid() ? "Paid" : "Unpaid";
                String cashPaid = participant.getCashPaid();
                String eTransferPaid = participant.geteTransferPaid();
                String specialNotes = participant.getSpecialNotes();

                writer.write(name + "," + status + "," + cashPaid + "," + eTransferPaid + "," + specialNotes);
                writer.newLine();
            }

            ExportFinanceOutputData outputData = new ExportFinanceOutputData();
            
            presenter.prepareSuccessView(outputData);
        } catch (IOException | RuntimeException e) {
            presenter.prepareFailView();
        }
    }
}
