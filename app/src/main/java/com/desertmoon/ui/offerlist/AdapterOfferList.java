package com.desertmoon.ui.offerlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.desertmoon.R;
import com.desertmoon.common.MenuItem;
import com.desertmoon.databinding.RowOfferItemsBinding;
import com.desertmoon.ui.MainActivityViewModel;

import java.util.List;


public class AdapterOfferList extends RecyclerView.Adapter<AdapterOfferList.MyViewHolder> {


    private static final String TAG = "AdapterOfferList";
    private FragmentActivity context;
    private List<MenuItem> listEditText;
    private LayoutInflater mInflater;
    RowOfferItemsBinding binding;
MainActivityViewModel mainActivityViewModel;
    NavController navController;

    public AdapterOfferList(FragmentActivity context, List<MenuItem> listEditText) {
        this.context = context;
        this.listEditText = listEditText;
        this.mInflater = LayoutInflater.from(context);
        mainActivityViewModel = ViewModelProviders.of(context).get(MainActivityViewModel.class);


    }

    @NonNull
    @Override
    public AdapterOfferList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        binding = DataBindingUtil.inflate(mInflater, R.layout.row_offer_items, viewGroup, false);
        View view = binding.getRoot();
        binding.setLifecycleOwner(context);
        binding.setCartItem(mainActivityViewModel);
     AdapterOfferList.MyViewHolder holder = new AdapterOfferList.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterOfferList.MyViewHolder myViewHolder, int i) {

        MenuItem beneficiary = listEditText.get(i);
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

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navigation.findNavController(view).navigate(R.id.action_fragOfferItemList_to_itemDescription);
                }
            });
        }

        public void setData(final MenuItem beneficiary) {


            try {

                Glide.with(context).load(context.getResources().getDrawable(beneficiary.getIntImageID()))
                        .diskCacheStrategy(DiskCacheStrategy.ALL)

                        .into(imageView);
                //   imageView.setImageDrawable(context.getResources().getDrawable(beneficiary.getIntImageID()));
                textViewMenu.setText(beneficiary.getStrTitle());
                textViewMenuDesc.setText(beneficiary.getStrTitleDescription());




            } catch (Exception e) {

            }


        }


    }
}
