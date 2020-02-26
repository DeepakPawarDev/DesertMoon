package com.desertmoon.ui.address;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

public class AddressViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;

    public AddressViewModel(@NonNull Application application) {
        super(application);
        mText = new MutableLiveData<>();
       // mText.setValue("This is slideshow fragment");
    }

    public void addAddressClick(){



    }

    public LiveData<String> getText() {
        return mText;
    }
}