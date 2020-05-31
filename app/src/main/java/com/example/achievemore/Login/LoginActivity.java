package com.example.achievemore.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.achievemore.MainActivity;
import com.example.achievemore.R;
import com.example.achievemore.SystemInfo.AppInfo;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    AppInfo appInfo = new AppInfo();
    LoginDetials LD = new LoginDetials();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            LD.SetUserCreds(getApplicationContext());
            TextView versionTV = findViewById(R.id.idVersionTV);
            TextView buildTV = findViewById(R.id.idbuildTV);
            versionTV.append(String.valueOf(appInfo.getAppVersionName()));
            buildTV.append(String.valueOf(appInfo.getAppBuildType()));

            final TextInputEditText usernameInputTV = findViewById(R.id.idUsernameTIET);
            final TextInputEditText passwordInputTV = findViewById(R.id.idPasswordTIET);
            final TextView usernameErrorFieldTV = findViewById(R.id.idusernameErrorTV);
            final TextView passwordErrorFieldTV = findViewById(R.id.idpasswordErrorTV);

            Button loginBtn = findViewById(R.id.idLoginBtn);
            Button regsiterBtn = findViewById(R.id.idRegisterBtn);

            loginBtn.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    if(usernameInputTV.length() == 0)
                    {
                        if (passwordInputTV.length() == 0)
                        {
                            passwordErrorFieldTV.setText("Enter a username");
                            passwordErrorFieldTV.setText("Enter a password");
                            return;
                        }
                        else
                        {
                            passwordErrorFieldTV.setText("Enter a username");
                            return;
                        }
                    }
                    else
                    {
                        if(passwordInputTV.length() == 0)
                        {
                            passwordInputTV.setText("Enter a password");
                        }
                        else
                        {
                            boolean usernameFound = LD.CheckUsername(usernameInputTV.getText().toString(), getApplicationContext());
                            boolean passwordCorrect = LD.CheckPassword((passwordInputTV.getText().toString()), getApplicationContext());

                            if(!usernameFound)
                            {
                                usernameErrorFieldTV.setText("Username does not exist");
                            }
                            else
                            {
                                if (!passwordCorrect)
                                {
                                    passwordErrorFieldTV.setText("password does not match");
                                }
                                else
                                {
                                    Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                                    LoginActivity.this.startActivity(mainIntent);
                                    LoginActivity.this.finish();
                                }
                            }
                        }
                    }
                }
            });
    }

}
