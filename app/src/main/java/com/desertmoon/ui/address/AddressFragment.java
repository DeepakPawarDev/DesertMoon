package com.desertmoon.ui.address;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.desertmoon.R;

public class AddressFragment extends Fragment {

    private AddressViewModel addressViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addressViewModel =
                ViewModelProviders.of(this).get(AddressViewModel.class);
        View root = inflater.inflate(R.layout.fragment_address, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        addressViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}