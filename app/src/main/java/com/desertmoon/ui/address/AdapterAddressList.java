package com.desertmoon.ui.address;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desertmoon.R;
import com.desertmoon.common.Menus;
import com.desertmoon.common.UserAddress;
import com.desertmoon.databinding.RowAddressListBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterAddressList extends RecyclerView.Adapter<com.desertmoon.ui.address.AdapterAddressList.MyViewHolder> {

    RowAddressListBinding binding;
    private static final String TAG = "AdapterAddressList";
    private FragmentActivity context;
    private List<UserAddress> listEditText;
    private LayoutInflater mInflater;


    public AdapterAddressList(FragmentActivity context, List<UserAddress> listEditText) {
        this.context = context;
        this.listEditText = listEditText;
        this.mInflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public com.desertmoon.ui.address.AdapterAddressList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        binding = DataBindingUtil.inflate(mInflater, R.layout.row_address_list, viewGroup, false);
        View view = binding.getRoot();
        com.desertmoon.ui.address.AdapterAddressList.MyViewHolder holder = new com.desertmoon.ui.address.AdapterAddressList.MyViewHolder(binding);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.desertmoon.ui.address.AdapterAddressList.MyViewHolder myViewHolder, int i) {

        UserAddress beneficiary = listEditText.get(i);
        myViewHolder.setData(beneficiary);

    }

    @Override
    public int getItemCount() {
        return listEditText.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        RowAddressListBinding rowAddressListBinding;


        public MyViewHolder(final RowAddressListBinding itemView) {
            super(itemView.getRoot());
            rowAddressListBinding = itemView;

        }

        public void setData(final UserAddress beneficiary) {

            rowAddressListBinding.textViewHeading.setText(beneficiary.getStrType());
            rowAddressListBinding.textViewDetails.setText(beneficiary.getStrSector() + " " + beneficiary.getStrPropertyNumber() + "\n" + beneficiary.getStrAddressLineOne() + " " + beneficiary.getGetStrAddressLineTwo());


        }


    }


}

