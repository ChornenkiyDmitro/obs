package com.example.splashscreen.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.splashscreen.FragmentForMainScreen.FragmentThemes;
import com.example.splashscreen.FragmentForMainScreen.FragmentMessages;
import com.example.splashscreen.FragmentForMainScreen.FragmentPeople;
import com.example.splashscreen.FragmentForMainScreen.FragmentProfile;


public class PagerAdapter extends FragmentStatePagerAdapter
{

    final int pageCount = 4;
    private String tabTitles[] = new String[] {"Themes", "Profile", "People", "Messages"};
    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FragmentThemes();
            case 1:
                return new FragmentProfile();
            case 2:
                return new FragmentPeople();
            case 3:
                return new FragmentMessages();


            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
