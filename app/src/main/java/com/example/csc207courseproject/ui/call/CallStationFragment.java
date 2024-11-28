package com.example.csc207courseproject.ui.call;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import com.example.csc207courseproject.R;
import com.example.csc207courseproject.databinding.FragmentCallSetBinding;
import com.example.csc207courseproject.databinding.FragmentCallStationsBinding;
import com.example.csc207courseproject.entities.EventData;
import com.example.csc207courseproject.entities.Station;
import com.example.csc207courseproject.interface_adapter.call_set.CallSetState;
import com.example.csc207courseproject.interface_adapter.upcoming_sets.UpcomingSetsController;
import com.example.csc207courseproject.interface_adapter.update_seeding.SeedingState;
import com.example.csc207courseproject.ui.AppFragment;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class CallStationFragment extends AppFragment implements PropertyChangeListener, AdapterView.OnItemSelectedListener {

    private static CallViewModel callViewModel;

    private FragmentCallStationsBinding binding;

    private AdapterView.OnItemSelectedListener listener = this;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        callViewModel.addPropertyChangeListener(this);

        binding = FragmentCallStationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        createStationDisplay();

        return root;
    }

    public void createStationDisplay(){
        CallSetState currentState = callViewModel.getState();
        ListView stationsView = binding.stationsList;
        List<Station> stations = currentState.getStations();

        ArrayAdapter<Station> stationAdapter =
                new ArrayAdapter<Station>(mContext, android.R.layout.simple_list_item_1, stations) {
            @Override
            public int getCount() {
                return stations.size();
            }

            @Override
            public Station getItem(int position) {
                return stations.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                Station station = stations.get(position);


                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.list_stations, parent, false);

                    // Create title
                    TextView title = convertView.findViewById(R.id.station_title);
                    String stationText = "Station " + station.getStationNum();
                    title.setText(stationText);

                    // Create tags list
                    TextView tags = convertView.findViewById(R.id.station_tags);
                    String tagsText = "Tags: " + station.tagsToString();
                    tags.setText(tagsText);

                    // Create tag select
                    Spinner tagSelect = convertView.findViewById(R.id.tag_select);
                    List<String> possibleTags = EventData.getPossibleTags();
                    ArrayAdapter<String> tagsAdapter = new ArrayAdapter<>(mContext,
                            android.R.layout.simple_spinner_dropdown_item, possibleTags);
                    tagsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    tagSelect.setAdapter(tagsAdapter);
                    tagSelect.setOnItemSelectedListener(listener);

                    // Create add button
                    Button addButton = convertView.findViewById(R.id.add_button);
                    addButton.setOnClickListener(view -> showToast("add " + station.getStationNum()));

                    // Create remove button
                    Button removeButton = convertView.findViewById(R.id.remove_button);
                    removeButton.setOnClickListener(view -> showToast("remove " + station.getStationNum()));

                }

                return convertView;
            }
        };

        stationsView.setAdapter(stationAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

    public static void setCallViewModel(CallViewModel viewModel) {
        callViewModel = viewModel;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedOption = (String) adapterView.getItemAtPosition(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}