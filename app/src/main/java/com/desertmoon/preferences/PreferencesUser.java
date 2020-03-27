package com.desertmoon.preferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesUser {
    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;
    private static final String FIND_PREFS = "PREF_MASTERS";
    private static final String TAG = "PreferenceSplashScreen";


    private String PREF_USER_MOBILE_NUMBER = "pref_user_mobile_number";
    private String PREF_USER_NAME = "pref_user_name";


    public PreferencesUser(Context context) {
        this.appSharedPrefs = context.getSharedPreferences(FIND_PREFS, Activity.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }


    public String getPrefUserMobileNo() {


        String str = appSharedPrefs.getString(PREF_USER_MOBILE_NUMBER, null);


        return str;
    }

    public void setPrefUserMobileNo(String str) {

        prefsEditor.putString(PREF_USER_MOBILE_NUMBER, str).commit();
    }

    public String getPrefUserName() {


        String str = appSharedPrefs.getString(PREF_USER_NAME, null);


        return str;
    }

    public void setPrefUserName(String str) {

        prefsEditor.putString(PREF_USER_NAME, str).commit();
    }

}