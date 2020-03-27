package com.desertmoon.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.desertmoon.MainActivity;
import com.desertmoon.R;
import com.desertmoon.firebasedatabaseapi.APIClient;
import com.desertmoon.firebasedatabaseapi.DatabaseRepository;
import com.desertmoon.model.SplashScreen;
import com.desertmoon.preferences.PreferenceSplashScreen;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen2);
        callSplashScreen();


        final Window window = getWindow();

// clear FLAG_TRANSLUCENT_STATUS flag:
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

// finally change the color


        final PreferenceSplashScreen preferenceSplashScreen = new PreferenceSplashScreen(getApplicationContext());
        final ImageView imageView = (ImageView) findViewById(R.id.image_view_splash);

        if (preferenceSplashScreen.getPrefSplashScreenIsShowImage()) {

            try {
                Picasso.with(this)
                        .setIndicatorsEnabled(true);


                Picasso.with(this)


                        .load(preferenceSplashScreen.getPrefSplashScreenImageURL())

                        .fetch(new com.squareup.picasso.Callback() {
                            @Override
                            public void onSuccess() {

                                switch (preferenceSplashScreen.getPrefSplashScaleType()) {

                                    case 5:
                                        imageView.setScaleType(ImageView.ScaleType.CENTER);


                                        break;

                                    case 6:
                                        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                                        break;


                                    case 7:
                                        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);


                                        break;


                                    case 3:
                                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);


                                        break;

                                    case 4:
                                        imageView.setScaleType(ImageView.ScaleType.FIT_END);


                                        break;


                                    case 2:
                                        imageView.setScaleType(ImageView.ScaleType.FIT_START);


                                        break;

                                    case 1:
                                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);


                                        break;

                                }

                                window.setStatusBarColor(Color.parseColor(preferenceSplashScreen.getPrefSplashStatusBackground()));
                                ((LinearLayout) findViewById(R.id.linear_layout_splash)).setBackgroundColor(Color.parseColor(preferenceSplashScreen.getPrefSplashBackground()));
                                System.out.println("*************** scale type " + imageView.getScaleType());
                                Picasso.with(getApplicationContext())


                                        .load(preferenceSplashScreen.getPrefSplashScreenImageURL())
                                        .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
                                        .into(imageView);

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {


                                        Intent intent = new Intent(SpashScreenActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                                        SpashScreenActivity.this.finish();

                                    }
                                }, 3000);
                            }

                            @Override
                            public void onError() {

                            }
                        })
                ;
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {

            try {

                window.setStatusBarColor(Color.parseColor("#FFC107"));
                ((LinearLayout) findViewById(R.id.linear_layout_splash)).setBackgroundColor(Color.parseColor("#FFC107"));
                Picasso.with(getApplicationContext())


                        .load(R.drawable.spash)
                        .into(imageView);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        Intent intent = new Intent(SpashScreenActivity.this, MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.right_in, R.anim.left_out);
                        SpashScreenActivity.this.finish();

                    }
                }, 3000);

            }catch (Exception e){

                e.printStackTrace();
            }
            }



    }


    private void callSplashScreen() {


        DatabaseRepository apiInterface = APIClient.getClient().create(DatabaseRepository.class);


        /**
         GET List Resources
         **/
        Call<SplashScreen> call = apiInterface.getSplashScreenDetails();
        call.enqueue(new Callback<SplashScreen>() {

            @Override
            public void onResponse(Call<SplashScreen> call, Response<SplashScreen> response) {

                SplashScreen serviceDiscriptions = response.body();

                try {

                    PreferenceSplashScreen preferenceSplashScreen = new PreferenceSplashScreen(getApplicationContext());
                    preferenceSplashScreen.setPrefSplashScreenImageURL(serviceDiscriptions.getImageURL());
                    preferenceSplashScreen.setPrefSplashScreenIsShowImage(serviceDiscriptions.isShow());
                    preferenceSplashScreen.setPrefSplashBackground(serviceDiscriptions.getBackgroundColor());
                    preferenceSplashScreen.setPrefSplashStatusBackground(serviceDiscriptions.getStatusColor());
                    preferenceSplashScreen.setPrefSplashScaleType(serviceDiscriptions.getScaleType());

                    System.out.println("*************** " + serviceDiscriptions.getScaleType());
                } catch (Exception e) {

                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<SplashScreen> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }


}
