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
import com.desertmoon.common.MenuItem;
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
        binding = DataBindingUtil.inflate(inflater, R.layout.frag_offer_item_list_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragOfferItemListViewModel.class);


        MenuItem menus = new MenuItem();
        menus.setIntImageID(R.drawable.menu1);
        menus.setStrTitle("Meal Box");
        menus.setDblPrice(320);
        menus.setStrTitleDescription("Testy tong, 10% off use code #10DDD");

        MenuItem menus1 = new MenuItem();
        menus1.setIntImageID(R.drawable.menu2);
        menus1.setStrTitle("Combo Box");
        menus1.setDblPrice(320);
        menus1.setStrTitleDescription("The good life, 15% off");


        MenuItem menus2 = new MenuItem();
        menus2.setIntImageID(R.drawable.menu3);
        menus2.setDblPrice(320);
        menus2.setStrTitle("Meal Box");
        menus2.setStrTitleDescription("Essential life, 20% off");

        MenuItem menus3 = new MenuItem();
        menus3.setIntImageID(R.drawable.menu4);
        menus3.setStrTitle("Chines");
        menus3.setStrTitleDescription("Testy tong, 10% off use code #10DDD");
        menus3.setDblPrice(320);


        MenuItem menus4 = new MenuItem();
        menus4.setDblPrice(320);
        menus4.setIntImageID(R.drawable.manu5);
        menus4.setStrTitle("Veg Main Course");
        menus4.setStrTitleDescription("Essential life, 20% off");
        menus4.setDblPrice(320);

        MenuItem menus5 = new MenuItem();
        menus5.setIntImageID(R.drawable.menu6);
        menus5.setStrTitle("Starters");
        menus5.setStrTitleDescription("The good life, 15% off");
        menus5.setDblPrice(320);
        ArrayList<MenuItem> menusArrayList = new ArrayList<>();

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

        AdapterOfferList adapterOfferList = new AdapterOfferList(getActivity(), menusArrayList);
        binding.setMyAdapter(adapterOfferList);


        // TODO: Use the ViewModel
    }

}
