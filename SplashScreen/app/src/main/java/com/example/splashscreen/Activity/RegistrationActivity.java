package com.example.splashscreen.Activity;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.splashscreen.FragmentysForRegistration.FragmentEmailVerifyForChangePassword;
import com.example.splashscreen.FragmentysForRegistration.FragmentSignIn;
import com.example.splashscreen.FragmentysForRegistration.FragmentSignUp;
import com.example.splashscreen.R;
import com.example.splashscreen.onFragmentChangeListener;


public class RegistrationActivity extends AppCompatActivity implements onFragmentChangeListener {


    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration);
            getSupportActionBar().hide();
            int intentFragment = getIntent().getExtras().getInt("frgToLoad");
            switch (intentFragment){
                case 1:
                    onSignIn();
                    break;
                case 2:
                    onSignUp();
                    break;
        }
}


    @Override
    public void onRout(String type) {
        switch (type) {
            case "sign in" :
                   onSignIn();
                    break;
            case "sign up" :
                   onSignUp();
                    break;
            case "forgot your password":
                  onForgotYourPassword();
                    break;
            case "finish":
                finishAffinity();
        }
    }

    public void onSignIn(){
        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(R.id.fragment_case,new FragmentSignIn());
        ft1.commit();
    }
    public void onSignUp(){
        FragmentManager fm2 = getSupportFragmentManager();
        FragmentTransaction ft2 = fm2.beginTransaction();
        ft2.replace(R.id.fragment_case,new FragmentSignUp());
        ft2.commit();
    }

public void onForgotYourPassword(){
    FragmentManager fm5 = getSupportFragmentManager();
    FragmentTransaction ft5 = fm5.beginTransaction();
    ft5.replace(R.id.fragment_case, new FragmentEmailVerifyForChangePassword());
    ft5.addToBackStack(null);
    ft5.commit();
}

}

