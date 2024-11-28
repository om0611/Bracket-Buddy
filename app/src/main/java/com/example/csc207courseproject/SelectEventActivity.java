package com.example.csc207courseproject;

import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.csc207courseproject.interface_adapter.select_event.SelectEventController;
import com.example.csc207courseproject.interface_adapter.select_event.SelectEventViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class SelectEventActivity extends AppCompatActivity implements PropertyChangeListener {

    private static SelectEventController selectEventController;
    private static SelectEventViewModel selectEventViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_event);

        selectEventViewModel.addPropertyChangeListener(this);
    }

    protected void onStart() {
        super.onStart();
        ListView eventViewList = findViewById(R.id.event_list);
        TextView noEventText = findViewById(R.id.no_events_message);

        List<String> eventNames = selectEventViewModel.getState().getEventNames();
        List<Integer> eventIds = selectEventViewModel.getState().getEventIds();

        if (eventNames.isEmpty()) {
            eventViewList.setVisibility(View.GONE);
            noEventText.setVisibility(View.VISIBLE);
        }
        else {
            // pass the event names to the adapter, which will then show them within the list view
            ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, eventNames);
            eventViewList.setAdapter(arrayAdapter);

            // add an on-click listener to each item
            eventViewList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                    // pos is the index of the element that was clicked
                    Integer selectedEventId = eventIds.get(pos);
                    selectEventController.execute(selectedEventId);
                }
            });
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {

    }

    public static void setSelectEventController(SelectEventController selectEventController) {
        SelectEventActivity.selectEventController = selectEventController;
    }

    public static void setSelectEventViewModel(SelectEventViewModel selectEventViewModel) {
        SelectEventActivity.selectEventViewModel = selectEventViewModel;
    }
}