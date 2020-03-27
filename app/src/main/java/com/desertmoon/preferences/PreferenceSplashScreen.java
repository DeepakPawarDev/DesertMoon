package com.desertmoon.preferences;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONObject;

import java.util.Iterator;
import java.util.TreeMap;

public class PreferenceSplashScreen {
    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;
    private static final String FIND_PREFS = "PREF_MASTERS";
    private static final String TAG = "PreferenceSplashScreen";


    private String PREF_MASTER_SPLASH_SCREEN = "pref_master_splash_screen";
    private String PREF_MASTER_SPLASH_IS_SHOW = "pref_master_splash_is_show";
    private String PREF_MASTER_SPLASH_STATUS_COLOR = "pref_master_splash_status_color";
    private String PREF_MASTER_SPLASH_BACKGROUND_COLOR = "pref_master_splash_background_color";
    private String PREF_MASTER_SPLASH_SCALE_TYPE = "pref_master_splash_scale_type";

    public PreferenceSplashScreen(Context context) {
        this.appSharedPrefs = context.getSharedPreferences(FIND_PREFS, Activity.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }


    public int getPrefSplashScaleType() {


        int str = appSharedPrefs.getInt(PREF_MASTER_SPLASH_SCALE_TYPE, 5);


        return str;
    }

    public void setPrefSplashScaleType(Integer str) {

        prefsEditor.putInt(PREF_MASTER_SPLASH_SCALE_TYPE, str).commit();
    }


    public String getPrefSplashStatusBackground() {


        String str = appSharedPrefs.getString(PREF_MASTER_SPLASH_STATUS_COLOR, null);


        return str;
    }

    public void setPrefSplashStatusBackground(String str) {

        prefsEditor.putString(PREF_MASTER_SPLASH_STATUS_COLOR, str).commit();
    }


    public String getPrefSplashBackground() {


        String str = appSharedPrefs.getString(PREF_MASTER_SPLASH_BACKGROUND_COLOR, null);


        return str;
    }

    public void setPrefSplashBackground(String str) {

        prefsEditor.putString(PREF_MASTER_SPLASH_BACKGROUND_COLOR, str).commit();
    }


    public String getPrefSplashScreenImageURL() {


        String str = appSharedPrefs.getString(PREF_MASTER_SPLASH_SCREEN, null);


        return str;
    }

    public void setPrefSplashScreenImageURL(String str) {

        prefsEditor.putString(PREF_MASTER_SPLASH_SCREEN, str).commit();
    }


    public boolean getPrefSplashScreenIsShowImage() {


        Boolean aBoolean = appSharedPrefs.getBoolean(PREF_MASTER_SPLASH_IS_SHOW, false);


        return aBoolean;
    }

    public void setPrefSplashScreenIsShowImage(Boolean isShowImage) {

        prefsEditor.putBoolean(PREF_MASTER_SPLASH_IS_SHOW, isShowImage).commit();
    }

}
