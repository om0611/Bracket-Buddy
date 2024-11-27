package com.example.csc207courseproject;

import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.csc207courseproject.interface_adapter.select_tournament.SelectTournamentController;
import com.example.csc207courseproject.interface_adapter.select_tournament.SelectTournamentViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectTournamentActivity extends AppCompatActivity implements PropertyChangeListener {

    private static SelectTournamentController selectTournamentController;
    private static SelectTournamentViewModel selectTournamentViewModel;

    private List<String> tournamentNames;
    private List<Integer> tournamentIds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_tournament);

        selectTournamentViewModel.addPropertyChangeListener(this);
    }

    protected void onStart() {
        super.onStart();
        ListView tournamentViewList = findViewById(R.id.tournament_list);
        Map<Integer, String> tournaments = selectTournamentViewModel.getState().getTournaments();
        tournamentNames = new ArrayList<>();
        tournamentIds = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : tournaments.entrySet()) {
            tournamentNames.add(entry.getValue());
            tournamentIds.add(entry.getKey());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tournamentNames);
        tournamentViewList.setAdapter(arrayAdapter);
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
    }

    public static void setSelectTournamentController(SelectTournamentController selectTournamentController) {
        SelectTournamentActivity.selectTournamentController = selectTournamentController;
    }

    public static void setSelectTournamentViewModel(SelectTournamentViewModel selectTournamentViewModel) {
        SelectTournamentActivity.selectTournamentViewModel = selectTournamentViewModel;
    }
}
