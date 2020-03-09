package com.desertmoon;

import android.os.Bundle;

import com.desertmoon.common.MenuItem;
import com.desertmoon.databinding.ActivityMainBinding;
import com.desertmoon.ui.BaseActivity;
import com.desertmoon.ui.MainActivityViewModel;
import com.desertmoon.ui.cart.FragChekout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;


import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private AppBarConfiguration mAppBarConfiguration;
    ActivityMainBinding binding;
    MainActivityViewModel mainActivityViewModel;
    NavController navController1;
    public static ArrayList<MenuItem> menuItems = new ArrayList<>();
    Snackbar snackbar;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        binding.setLifecycleOwner(this);
        mainActivityViewModel.mutableLiveDataCardItem.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                if (integer == 1) {
                    Log.i(TAG, "added");
                    showSnack();
                } else {

                    Toast.makeText(getApplicationContext(), "Error in adding item in a cart, please try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        toolBarAndNavigationSetting();
        setListeners();

    }


    private void toolBarAndNavigationSetting() {


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_orders, R.id.nav_address,
                R.id.nav_cash_back, R.id.nav_notifications, R.id.nav_contact_us, R.id.nav_share)
                .setDrawerLayout(drawer)
                .build();
        navController1 = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController1, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController1);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }




    public void showSnack() {


         snackbar = Snackbar.make(findViewById(R.id.coordinate_layout), "", Snackbar.LENGTH_INDEFINITE);
        Snackbar.SnackbarLayout layout = (Snackbar.SnackbarLayout) snackbar.getView();
        layout.setPadding(0, 0, 0, 0);
        layout.setBackgroundColor(ContextCompat.getColor(this, R.color.primaryDarkColor));
        View snackView = getLayoutInflater().inflate(R.layout.custom_snackbar, null);
        layout.addView(snackView);
        layout.setClickable(true);



        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // navController1.navigate(R.id.action_nav_home_to_fragChekout);
                checkoutNavigate(navController1);
            }
        });
snackbar.show();
        //hideSnackCheckout(navController1,snackbar);



    }


    private void setListeners(){

        navController1.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                hideSnackCheckout(navController1,snackbar);            }
        });

    }


}
