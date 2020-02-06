package com.desertmoon.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

import com.desertmoon.MainActivity;
import com.desertmoon.R;
import com.desertmoon.ui.login.Login;
import com.desertmoon.ui.spash.SpashScreen;

public class SpashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent=new Intent(SpashScreenActivity.this, Login.class);
                startActivity(intent);
                SpashScreenActivity.this.finish();

            }
        },500);


    }
}
