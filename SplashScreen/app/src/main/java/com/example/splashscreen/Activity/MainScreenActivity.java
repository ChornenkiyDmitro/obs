package com.example.splashscreen.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.splashscreen.DataBaseFile.DatabaseHelper;
import com.example.splashscreen.FragmentForMainScreen.FragmentMessages;
import com.example.splashscreen.FragmentForMainScreen.FragmentPeople;
import com.example.splashscreen.FragmentForMainScreen.FragmentProfile;
import com.example.splashscreen.FragmentForMainScreen.FragmentThemes;
import com.example.splashscreen.FragmentysForRegistration.FragmentSignIn;
import com.example.splashscreen.R;
import com.example.splashscreen.onFragmentChangeListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainScreenActivity extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        onTheme();




        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bn_main_screen);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.page_themes:
                        onTheme();
                        break;
                    case R.id.page_profile:
                        onProfile();
                        break;
                    case R.id.page_people:
                        setTitle(R.string.main_screen_people_bottom);
                        onPeople();
                        break;
                    case R.id.page_messages:
                       setTitle(R.string.main_screen_messages_bottom);
                        onMessages();
                        break;
                }
                return true;
            }
        });
        }

private void onTheme(){
    setTitle(R.string.main_screen_themes_bottom);

    FragmentManager fm1 = getSupportFragmentManager();
    FragmentTransaction ft1 = fm1.beginTransaction();
    ft1.replace(R.id.fl_main_screen_case_fragment,new FragmentThemes());
    ft1.commit();
}
    private void onProfile(){
        setTitle(R.string.main_screen_profile_bottom);

        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(R.id.fl_main_screen_case_fragment,new FragmentProfile());
        ft1.commit();
    }
    private void onPeople(){
        setTitle(R.string.main_screen_people_bottom);

        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(R.id.fl_main_screen_case_fragment,new FragmentPeople());
        ft1.commit();
    }
    private void onMessages(){
        setTitle(R.string.main_screen_messages_bottom);

        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(R.id.fl_main_screen_case_fragment,new FragmentMessages());
        ft1.commit();
    }
}