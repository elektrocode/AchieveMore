package com.example.achievemore.Login;

import android.content.Context;
import android.content.SharedPreferences;

public class LoginDetials {

    Context context;
    SharedPreferences sp;
    private static final String mypreference = "UserLoginDetialsPref";
    private static final String Username = "usernamekey";
    private static final String Password = "passwordKey";

    public void LoginDetials()
    {

    }

    public boolean CheckUsername(String suppliedUsername)
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

    public boolean CheckPassword(String SuppliedPassword)
    {
        sp = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);

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

    public boolean SetUsername()
    {

        return true;
    }

    public boolean SetPassword()
    {

        return true;
    }
}
