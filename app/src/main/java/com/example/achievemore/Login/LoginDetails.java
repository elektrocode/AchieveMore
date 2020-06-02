package com.example.achievemore.Login;

import android.content.Context;
import android.content.SharedPreferences;

public class LoginDetails {

    SharedPreferences sp;
    private static final String mypreference = "UserLoginDetailsPref";
    private static final String Username = "usernamekey";
    private static final String Password = "passwordKey";

    public void LoginDetails()
    {

    }

    public boolean CheckUsername(String suppliedUsername, Context context)
    {
        boolean found;
        sp = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        String RetrievedUsername = sp.getString("usernameKey",null);

        if(suppliedUsername.equals(RetrievedUsername))
        {
            found = true;
        }
        else
        {
            found = false;
        }
        return found;
    }

    public boolean CheckPassword(String SuppliedPassword, Context context)
    {
        boolean found;
        SharedPreferences sp = context.getSharedPreferences(mypreference, Context.MODE_PRIVATE);

        String RetrievedPassword = sp.getString("passwordKey",null);

        if(RetrievedPassword.equals(SuppliedPassword))
        {
           found = true;
        }
        else
        {
            found = false;
        }
        return found;
    }

    public void DevelopmemtSetUserCreds(Context context)
    {
        SharedPreferences sp = context.getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        SharedPreferences.Editor Ed =sp.edit();
        Ed.putString("usernameKey","testing");
        Ed.putString("passwordKey","password1234");
        Ed.apply();
    }

    public void SetUserCreds(Context context, String suppliedusername, String suppliedpassword)
    {
        SharedPreferences sp = context.getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        SharedPreferences.Editor Ed =sp.edit();
        Ed.putString("usernameKey",suppliedusername);
        Ed.putString("passwordKey",suppliedpassword);
        Ed.apply();
    }
}
