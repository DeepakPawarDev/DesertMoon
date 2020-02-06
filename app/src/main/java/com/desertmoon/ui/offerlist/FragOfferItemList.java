package com.desertmoon.ui.offerlist;

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
import com.desertmoon.databinding.FragOfferItemListFragmentBinding;
import com.desertmoon.ui.home.AdapterHomeMenu;

import java.util.ArrayList;

public class FragOfferItemList extends Fragment {

    private FragOfferItemListViewModel mViewModel;
    FragOfferItemListFragmentBinding binding;

    public static FragOfferItemList newInstance() {
        return new FragOfferItemList();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.frag_offer_item_list_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragOfferItemListViewModel.class);




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

        AdapterOfferList adapterOfferList=new AdapterOfferList(getActivity(),menusArrayList);
        binding.setMyAdapter(adapterOfferList);





        // TODO: Use the ViewModel
    }

}
