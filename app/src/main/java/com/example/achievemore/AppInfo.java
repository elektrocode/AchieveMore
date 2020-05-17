package com.example.achievemore;

import androidx.appcompat.app.AppCompatActivity;

public class AppInfo extends AppCompatActivity
{
    public int getAppVersionCode()
    {
        return BuildConfig.VERSION_CODE;
    }

    public String getAppVersionName()
    {
        return (" " + BuildConfig.VERSION_NAME);
    }

    public String getAppCreators()
    {
        return (" " + BuildConfig.AUTHORS);
    }
    public String getAppBuildType()
    {
        return (" " + BuildConfig.BUILDSTAGE +" - " + BuildConfig.BUILD_TYPE);
    }
}

