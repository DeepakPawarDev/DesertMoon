package com.desertmoon.ui.notifications;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.desertmoon.R;
import com.desertmoon.common.Menus;
import com.desertmoon.common.Notifications;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterNotification extends RecyclerView.Adapter<com.desertmoon.ui.notifications.AdapterNotification.MyViewHolder> {


    private static final String TAG = "AdapterNotification";
    private FragmentActivity context;
    private List<Notifications> listEditText;
    private LayoutInflater mInflater;




    public AdapterNotification(FragmentActivity context, List<Notifications> listEditText) {
        this.context = context;
        this.listEditText = listEditText;
        this.mInflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public com.desertmoon.ui.notifications.AdapterNotification.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =       mInflater.inflate  ( R.layout.row_notification, viewGroup, false);

        com.desertmoon.ui.notifications.AdapterNotification.MyViewHolder holder = new com.desertmoon.ui.notifications.AdapterNotification.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.desertmoon.ui.notifications.AdapterNotification.MyViewHolder myViewHolder, int i) {

        Notifications beneficiary = listEditText.get(i);
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

        public void setData(final Notifications beneficiary) {



        }


    }


}

