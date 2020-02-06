package com.desertmoon.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.desertmoon.R;
import com.desertmoon.common.Menus;
import com.desertmoon.databinding.FragmentHomeBinding;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = binding.getRoot();

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });


        SliderView sliderView=(SliderView)root.findViewById(R.id.cardView) ;
        sliderView.setSliderAdapter(new AdapterHomeOffers(getActivity()));

       // sliderView.startAutoCycle();
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);

        Menus menus=new Menus();
        menus.setIntImageID(R.drawable.menu1);
        menus.setStrTitle("Meal Box");
        menus.setStrTitleDescription("Testy tong, 10% off use code #10DDD");

        Menus menus1=new Menus();
        menus1.setIntImageID(R.drawable.menu2);
        menus1.setStrTitle("Combo Box");
        menus1.setStrTitleDescription("The good life, 15% off");


        Menus menus2=new Menus();
        menus2.setIntImageID(R.drawable.menu3);
        menus2.setStrTitle("Meal Box");
        menus2.setStrTitleDescription("Essential life, 20% off");

        Menus menus3=new Menus();
        menus3.setIntImageID(R.drawable.menu4);
        menus3.setStrTitle("Chines");
        menus3.setStrTitleDescription("Testy tong, 10% off use code #10DDD");



        Menus menus4=new Menus();
        menus4.setIntImageID(R.drawable.manu5);
        menus4.setStrTitle("Veg Main Course");
        menus4.setStrTitleDescription("Essential life, 20% off");


        Menus menus5=new Menus();
        menus5.setIntImageID(R.drawable.menu6);
        menus5.setStrTitle("Starters");
        menus5.setStrTitleDescription("The good life, 15% off");

        ArrayList<Menus> menusArrayList=new ArrayList<>();

        menusArrayList.add(menus);
        menusArrayList.add(menus1);

        menusArrayList.add(menus2);

        menusArrayList.add(menus3);

        menusArrayList.add(menus4);

        menusArrayList.add(menus5);

        menusArrayList.add(menus2);

        menusArrayList.add(menus3);

        menusArrayList.add(menus4);

        menusArrayList.add(menus5);
        menusArrayList.add(menus);
        menusArrayList.add(menus1);

        menusArrayList.add(menus2);

        menusArrayList.add(menus3);

        menusArrayList.add(menus4);

        menusArrayList.add(menus5);

        menusArrayList.add(menus2);

        menusArrayList.add(menus3);

        menusArrayList.add(menus4);

        menusArrayList.add(menus5);

        AdapterHomeMenu adapterHomeMenu=new AdapterHomeMenu(getActivity(),menusArrayList);
        binding.setMyAdapter(adapterHomeMenu);



        return root;
    }
}