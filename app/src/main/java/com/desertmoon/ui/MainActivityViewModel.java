package com.desertmoon.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.desertmoon.MainActivity;
import com.desertmoon.common.MenuItem;
import com.google.android.material.snackbar.Snackbar;

public class MainActivityViewModel extends AndroidViewModel {

    private Application application;
    private static final String TAG = "MainActivityCardViewMod";
    public MutableLiveData<Integer> mutableLiveDataCardItem = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.application=application;
    }

    public void addCartItem(MenuItem menuItem) {

        try {
            Log.i(TAG, "In method addCard()");

           // MainActivity.menuItems.add(menuItem);
            mutableLiveDataCardItem.postValue(1);
        }catch (Exception e){
            e.printStackTrace();
            mutableLiveDataCardItem.postValue(-1);

        }

    }


    public void removeCartItem(MenuItem menuItem) {

        Log.i(TAG, "In method removeCard()");
        try {


            MainActivity.menuItems.add(menuItem);
            mutableLiveDataCardItem.postValue(1);
        }catch (Exception e){
            e.printStackTrace();
            mutableLiveDataCardItem.postValue(-1);

        }

    }


}