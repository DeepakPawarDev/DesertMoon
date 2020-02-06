package com.desertmoon.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.desertmoon.R;
import com.desertmoon.ui.login.ui.login.LoginFragment;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, LoginFragment.newInstance())
                    .commitNow();
        }
    }
}
