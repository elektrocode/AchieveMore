package com.example.achievemore;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import java.net.ConnectException;

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

    public void setAppOpened(Context context)
    {
        SharedPreferences getPrefs = context.getSharedPreferences("MySharedPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = getPrefs.edit();
        int totalCount;

        totalCount = getPrefs.getInt("counter", 0);
        totalCount++;
        editor.putInt("counter", totalCount++);
        editor.commit();
    }

    public int getAppOpened(Context context)
    {
        SharedPreferences setPrefs =  context.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE);
        return setPrefs.getInt("counter", 0);
    }
}

