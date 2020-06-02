package com.example.achievemore.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.achievemore.MainActivity;
import com.example.achievemore.R;
import com.example.achievemore.SystemInfo.AppInfo;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    AppInfo appInfo = new AppInfo();
    LoginDetails LD = new LoginDetails();

    TextInputEditText usernameInputTV, passwordInputTV;
    TextView versionTV, buildTV, usernameErrorFieldTV, passwordErrorFieldTV ;
    Button loginBtn, registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            usernameInputTV = findViewById(R.id.idUsernameTIET);
            passwordInputTV = findViewById(R.id.idPasswordTIET);

            usernameErrorFieldTV = findViewById(R.id.idusernameErrorTV);
            passwordErrorFieldTV = findViewById(R.id.idpasswordErrorTV);

            loginBtn = findViewById(R.id.idLoginBtn);
            registerBtn = findViewById(R.id.idRegisterBtn);

            buildTV = findViewById(R.id.idbuildTV);
            versionTV = findViewById(R.id.idVersionTV);

            LD.DevelopmemtSetUserCreds(getApplicationContext());
            versionTV.append(String.valueOf(appInfo.getAppVersionName()));
            buildTV.append(String.valueOf(appInfo.getAppBuildType()));

            loginBtn.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    login();
                }
            });

            registerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    register();
                }
            });
    }

    public void login()
    {
        if(usernameInputTV.length() == 0)
        {
            if (passwordInputTV.length() == 0)
            {
                usernameErrorFieldTV.setText("Enter a username");
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
                passwordErrorFieldTV.setText("Enter a password");
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

    public void register()
    {
        String username = usernameInputTV.getText().toString();
        String password = passwordInputTV.getText().toString();
        LD.SetUserCreds(getApplicationContext(),username,password);
    }
}
