package com.example.achievemore.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.achievemore.SystemInfo.AppInfo;
import com.example.achievemore.R;

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

        appInfo.setAppOpened(getApplicationContext());
        TextView buildTV = findViewById(R.id.idbuildTV);
        TextView creatorsTV = findViewById(R.id.idcreatorsTV);
        TextView versionTV = findViewById(R.id.idcreatorsTV);
        TextView timesOpenedTV = findViewById(R.id.idtimesOpenedTV);

        buildTV.append(String.valueOf(appInfo.getAppBuildType()));
        creatorsTV.append(String.valueOf(appInfo.getAppCreators()));
        versionTV.append(String.valueOf(appInfo.getAppVersionName()));
        timesOpenedTV.append(String.valueOf(" " + appInfo.getAppOpened(getApplicationContext())));

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashscreenActivity.this, com.example.achievemore.Login.LoginActivity.class);
                SplashscreenActivity.this.startActivity(mainIntent);
                SplashscreenActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

