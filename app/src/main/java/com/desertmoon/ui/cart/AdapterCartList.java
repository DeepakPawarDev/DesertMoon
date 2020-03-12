package com.desertmoon.ui.cart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desertmoon.R;
import com.desertmoon.common.Menus;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterCartList extends RecyclerView.Adapter<com.desertmoon.ui.cart.AdapterCartList.MyViewHolder> {


    private static final String TAG = "AdapterCartList";
    private FragmentActivity context;
    private List<Menus> listEditText;
    private LayoutInflater mInflater;




    public AdapterCartList(FragmentActivity context, List<Menus> listEditText) {
        this.context = context;
        this.listEditText = listEditText;
        this.mInflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public com.desertmoon.ui.cart.AdapterCartList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =       mInflater.inflate  ( R.layout.row_cart_items, viewGroup, false);

        com.desertmoon.ui.cart.AdapterCartList.MyViewHolder holder = new com.desertmoon.ui.cart.AdapterCartList.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.desertmoon.ui.cart.AdapterCartList.MyViewHolder myViewHolder, int i) {

        Menus beneficiary = listEditText.get(i);
        myViewHolder.setData(beneficiary);

    }

    @Override
    public int getItemCount() {
        return listEditText.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {



        public MyViewHolder(final View itemView) {
            super(itemView);


        }

        public void setData(final Menus beneficiary) {



        }


    }


}

