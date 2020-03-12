package com.desertmoon.ui.cart;

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
import com.desertmoon.common.Menus;
import com.desertmoon.databinding.FragChekoutBinding;

import java.util.ArrayList;

public class FragChekout extends Fragment {

    private FragChekoutViewModel mViewModel;
    FragChekoutBinding binding;

    public static FragChekout newInstance() {
        return new FragChekout();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.frag_chekout, container, false);
        setAdapter();
        return binding.getRoot();
    }

    private void setAdapter() {
        ArrayList<Menus> menusArrayList=new ArrayList<>();

        Menus menu=new Menus();

        menusArrayList.add(menu);
        menusArrayList.add(menu);
        menusArrayList.add(menu);


        AdapterCartList adapterCartList=new AdapterCartList(getActivity(),menusArrayList);
        binding.setMyAdapter(adapterCartList);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragChekoutViewModel.class);
        // TODO: Use the ViewModel
    }

}
