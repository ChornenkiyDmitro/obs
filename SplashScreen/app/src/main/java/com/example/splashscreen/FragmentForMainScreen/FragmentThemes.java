package com.example.splashscreen.FragmentForMainScreen;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.splashscreen.Activity.WelcomeActivity;
import com.example.splashscreen.R;

import static androidx.core.app.ActivityCompat.finishAffinity;


public class FragmentThemes extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_themes, container, false);

        Button logOut = (Button) view.findViewById(R.id.gogog);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WelcomeActivity.class);
                startActivity(intent);
                finishAffinity(getActivity());

            }
        });

        return view;
    }
}