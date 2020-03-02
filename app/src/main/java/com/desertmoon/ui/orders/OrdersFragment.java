package com.desertmoon.ui.orders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.desertmoon.R;
import com.desertmoon.common.Menus;
import com.desertmoon.databinding.FragmentOrdersBinding;

import java.util.ArrayList;

public class OrdersFragment extends Fragment {

    private OrdersViewModel ordersViewModel;
    FragmentOrdersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_orders, container, false);
        ordersViewModel =
                ViewModelProviders.of(this).get(OrdersViewModel.class);
        View root = binding.getRoot();
        final TextView textView = root.findViewById(R.id.text_gallery);
        ordersViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        initialize();

        return root;
    }

    private void initialize() {
        ArrayList<Menus> menusArrayList=new ArrayList<>();

        Menus menu=new Menus();

        menusArrayList.add(menu);
        menusArrayList.add(menu);
        menusArrayList.add(menu);
        menusArrayList.add(menu);
        menusArrayList.add(menu);
        menusArrayList.add(menu); menusArrayList.add(menu);
        menusArrayList.add(menu);

        AdapterOrderHistory adapterOrderHistory=new AdapterOrderHistory(getActivity(),menusArrayList);
        binding.setAdapter(adapterOrderHistory);





    }
}