package com.desertmoon.ui.home;

import android.database.DatabaseUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.desertmoon.R;
import com.desertmoon.common.Menus;
import com.desertmoon.databinding.RowHomeMenuBinding;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


public class AdapterHomeMenu extends RecyclerView.Adapter<AdapterHomeMenu.MyViewHolder> {


    private static final String TAG = "AdapterHomeMenu";
    private FragmentActivity context;
    private List<Menus> listEditText;
    private LayoutInflater mInflater;
    RowHomeMenuBinding binding;

    NavController navController;

    public AdapterHomeMenu(FragmentActivity context, List<Menus> listEditText) {
        this.context = context;
        this.listEditText = listEditText;
        this.mInflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public AdapterHomeMenu.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = DataBindingUtil.inflate(mInflater, R.layout.row_home_menu, viewGroup, false);
        View view = binding.getRoot();
        AdapterHomeMenu.MyViewHolder holder = new AdapterHomeMenu.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHomeMenu.MyViewHolder myViewHolder, int i) {

        Menus beneficiary = listEditText.get(i);
        myViewHolder.setData(beneficiary);

    }

    @Override
    public int getItemCount() {
        return listEditText.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        View view;
        TextView textViewMenu,textViewMenuDesc;
        ImageView imageView;

        public MyViewHolder(final View itemView) {
            super(itemView);

            view = itemView;
            imageView= view.findViewById(R.id.image);
            textViewMenu=view.findViewById(R.id.text_view_menu);
            textViewMenuDesc=view.findViewById(R.id.text_view_menu_details);
        }

        public void setData(final Menus beneficiary) {


            try {


               imageView.setImageDrawable(context.getResources().getDrawable(beneficiary.getIntImageID()));
                textViewMenu.setText(beneficiary.getStrTitle());
                textViewMenuDesc.setText(beneficiary.getStrTitleDescription());

            } catch (Exception e) {

            }


        }


    }
}
