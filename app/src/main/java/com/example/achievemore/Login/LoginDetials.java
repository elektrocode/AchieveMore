package com.example.achievemore.Login;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class LoginDetials {

    SharedPreferences sp;
    private static final String mypreference = "UserLoginDetialsPref";
    private static final String Username = "usernamekey";
    private static final String Password = "passwordKey";

    public void LoginDetials()
    {

    }

    public boolean CheckUsername(String suppliedUsername, Context context)
    {
        sp = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        String RetrievedUsername = sp.getString("usernameKey",null);

        if( suppliedUsername == RetrievedUsername )
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean CheckPassword(String SuppliedPassword, Context context)
    {
        SharedPreferences sp = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        String RetrievedPassword = sp.getString("passwordKey",null);

        if( RetrievedPassword == SuppliedPassword )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void SetUserCreds(Context context)
    {
        SharedPreferences sp = context.getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        SharedPreferences.Editor Ed =sp.edit();
        Ed.putString("usernameKey","testing" );
        Ed.putString("passwordKey","password1234");
        Ed.apply();
    }
}
