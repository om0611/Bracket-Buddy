package com.example.csc207courseproject.ui.call;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.example.csc207courseproject.databinding.FragmentCallBinding;
import com.example.csc207courseproject.ui.AppFragment;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CallFragment extends AppFragment implements PropertyChangeListener {

    private static CallViewModel callViewModel;

private FragmentCallBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        // callViewModel.addPropertyChangeListener(this);

        binding = FragmentCallBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCall;
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
}