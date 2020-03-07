package com.desertmoon.ui.address;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.desertmoon.R;
import com.desertmoon.common.UserAddress;
import com.desertmoon.databinding.FragmentAddressBinding;

import java.util.ArrayList;

public class AddressFragment extends Fragment {

    private AddressViewModel addressViewModel;

    FragmentAddressBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_address, container, false);
        addressViewModel =
                ViewModelProviders.of(this).get(AddressViewModel.class);
        View root =binding.getRoot();
        final TextView textView = root.findViewById(R.id.text_slideshow);
        addressViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        setListeners();
        initialize();

        return root;
    }

    private void initialize() {

        ArrayList<UserAddress> userAddresses=new ArrayList<>();
        UserAddress userAddress=new UserAddress();
        userAddress.setStrType("Home");
        userAddress.setStrSector("Sector 7");
        userAddress.setStrPropertyNumber("502 Karan Chass");
        userAddress.setStrAddressLineOne("Near PMC cooperative bank");
        userAddress.setGetStrAddressLineTwo("Airoli");

        userAddresses.add(userAddress);
        userAddresses.add(userAddress);
        userAddresses.add(userAddress);

        AdapterAddressList adapterAddressList=new AdapterAddressList(getActivity(),userAddresses);

        binding.setAdapter(adapterAddressList);




    }

    private void setListeners() {

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_nav_address_to_addAddressFragment);
            }
        });

    }
}