package com.desertmoon.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityCardViewModel extends AndroidViewModel {

    private static final String TAG = "MainActivityCardViewMod";
    public MutableLiveData<Integer> mutableLiveDataCardItem = new MutableLiveData<>();

    public MainActivityCardViewModel(@NonNull Application application) {
        super(application);
    }

    public void addCartItem() {

        Log.i(TAG,"In method addCard()");

        mutableLiveDataCardItem.postValue(1);

    }
}