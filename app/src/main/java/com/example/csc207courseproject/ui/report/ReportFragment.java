package com.example.csc207courseproject.ui.report;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider; // DELETE THIS LATER AAAAAAAA
import com.example.csc207courseproject.databinding.FragmentReportBinding;
import org.jetbrains.annotations.NotNull;

public class ReportFragment extends Fragment {

    private FragmentReportBinding binding;
    private Context mContext;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ReportViewModel reportViewModel =
                new ViewModelProvider(this).get(ReportViewModel.class);

        binding = FragmentReportBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textReport;
        reportViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        showToast("HAIIII :3");
        Log.d("EXAMPLE DEBUG", "HAIIII");
        return root;
    }

    @Override
    public void onAttach(@NotNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}