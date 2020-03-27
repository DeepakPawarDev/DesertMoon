package com.desertmoon.firebasedatabaseapi;

import com.desertmoon.model.SplashScreen;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface DatabaseRepository {




    @GET("SplashScreen.json")
    Call<SplashScreen> getSplashScreenDetails();


}
