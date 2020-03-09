package com.desertmoon.ui.discription;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desertmoon.R;
import com.desertmoon.databinding.ItemDescriptionFragmentBinding;
import com.desertmoon.ui.MainActivityViewModel;

public class ItemDescription extends Fragment {

    private ItemDescriptionViewModel mViewModel;
    private MainActivityViewModel mainActivityViewModel;
    private ItemDescriptionFragmentBinding binding;

    public static ItemDescription newInstance() {
        return new ItemDescription();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mainActivityViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);

        binding = DataBindingUtil.inflate(inflater, R.layout.item_description_fragment, container, false);
        binding.setCartItem(mainActivityViewModel);
        binding.setLifecycleOwner(getActivity());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ItemDescriptionViewModel.class);
        // TODO: Use the ViewModel
    }

}
