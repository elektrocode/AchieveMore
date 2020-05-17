package com.example.achievemore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashscreenActivity extends AppCompatActivity
{
    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 4000;

    AppInfo appInfo = new AppInfo();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TextView buildTV = findViewById(R.id.idbuildTV);
        TextView creatorsTV = findViewById(R.id.idcreatorsTV);
        TextView versionTV = findViewById(R.id.idVersionTV);

        buildTV.append(String.valueOf(appInfo.getAppBuildType()));
        creatorsTV.append(String.valueOf(appInfo.getAppCreators()));
        versionTV.append(String.valueOf(appInfo.getAppVersionName()));


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashscreenActivity.this, MainActivity.class);
                SplashscreenActivity.this.startActivity(mainIntent);
                SplashscreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

