package com.desertmoon.ui;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.desertmoon.R;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }



    //Navigate to checkout from specific nav controller
    public void checkoutNavigate(NavController navController){

        switch (navController.getCurrentDestination().getId()) {


            case R.id.nav_home:
                navController.navigate(R.id.action_nav_home_to_fragChekout);
                break;
            case R.id.nav_orders:
                navController.navigate(R.id.action_nav_orders_to_fragChekout);
                break;
            case R.id.nav_address:
                navController.navigate(R.id.action_nav_address_to_fragChekout);
                break;

            case R.id.nav_cash_back:
                navController.navigate(R.id.action_nav_cash_back_to_fragChekout);
                break;

            case R.id.nav_contact_us:

                break;


            case R.id.nav_share:

                break;


            case R.id.fragOfferItemList:
                navController.navigate(R.id.action_fragOfferItemList_to_fragChekout);
                break;


            case R.id.itemDescription:
                navController.navigate(R.id.action_itemDescription_to_fragChekout);
                break;


            case R.id.nav_notifications:

                break;


            case R.id.fragChekout:

                break;





        }



    }


    //Hide snackbar for specific destination
    public void hideSnackCheckout(NavController navController, Snackbar snackbar){

        if (snackbar!=null) {
            switch (navController.getCurrentDestination().getId()) {


                case R.id.nav_home:
                    snackbar.show();
                    break;
                case R.id.nav_orders:
                    snackbar.show();
                    break;
                case R.id.nav_address:
                    snackbar.dismiss();
                    break;

                case R.id.nav_cash_back:
                    snackbar.show();
                    break;

                case R.id.nav_contact_us:
                    snackbar.dismiss();
                    break;


                case R.id.nav_share:
                    snackbar.dismiss();
                    System.out.println("*****************");
                    break;


                case R.id.fragOfferItemList:
                    snackbar.show();
                    break;


                case R.id.itemDescription:
                    snackbar.show();
                    break;


                case R.id.nav_notifications:
                    snackbar.dismiss();
                    break;


                case R.id.fragChekout:
                    snackbar.dismiss();
                    break;


            }

        }

    }


}
