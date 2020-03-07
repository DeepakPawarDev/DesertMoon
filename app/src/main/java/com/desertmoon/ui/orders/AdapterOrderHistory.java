package com.desertmoon.ui.orders;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.fragment.app.FragmentActivity;
        import androidx.recyclerview.widget.RecyclerView;

        import com.desertmoon.R;
        import com.desertmoon.common.Menus;

        import java.util.List;

public class AdapterOrderHistory extends RecyclerView.Adapter<com.desertmoon.ui.orders.AdapterOrderHistory.MyViewHolder> {


    private static final String TAG = "AdapterOrderHistory";
    private FragmentActivity context;
    private List<Menus> listEditText;
    private LayoutInflater mInflater;




    public AdapterOrderHistory(FragmentActivity context, List<Menus> listEditText) {
        this.context = context;
        this.listEditText = listEditText;
        this.mInflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public com.desertmoon.ui.orders.AdapterOrderHistory.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =       mInflater.inflate  ( R.layout.row_order_history, viewGroup, false);

        com.desertmoon.ui.orders.AdapterOrderHistory.MyViewHolder holder = new com.desertmoon.ui.orders.AdapterOrderHistory.MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull com.desertmoon.ui.orders.AdapterOrderHistory.MyViewHolder myViewHolder, int i) {

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

