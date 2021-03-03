package com.example.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.splashscreen.Activity.MainScreenActivity;
import com.example.splashscreen.Activity.WelcomeActivity;
import com.example.splashscreen.DataBaseFile.DatabaseHelper;
import com.example.splashscreen.DataBaseFile.User;

public class SplashActivity extends AppCompatActivity
{

    DatabaseHelper databaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        getSupportActionBar().hide();
databaseHelper = new DatabaseHelper(this);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
               // databaseHelper.removeAll();
            handlerRout();
            }
        }, 3000 );
    }

    private void goToScreen(int typeScreen)
    {
        if(typeScreen == 1)
        {
            Intent nextScreen = new Intent(SplashActivity.this, MainScreenActivity.class);
            startActivity(nextScreen);
            finish();
        }
        else
        {
            Intent nextScreen = new Intent(SplashActivity.this, WelcomeActivity.class);
            startActivity(nextScreen);
            finish();
        }
    }


    private void handlerRout(){

        boolean cursor = databaseHelper.isMasterEmpty();

        if (cursor == false) {
            goToScreen(1);
        } else {
            goToScreen(0);
        }

    }

}