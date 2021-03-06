package com.example.splashscreen.FragmentysForRegistration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.splashscreen.Activity.MainScreenActivity;
import com.example.splashscreen.DataBaseFile.DatabaseHelper;
import com.example.splashscreen.DataBaseFile.User;
import com.example.splashscreen.R;
import com.example.splashscreen.onFragmentChangeListener;


public class FragmentSignUp extends Fragment {

    DatabaseHelper db;
    View view;
    onFragmentChangeListener listener;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof onFragmentChangeListener)
            listener = (onFragmentChangeListener) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_signup, container, false);
        db = new DatabaseHelper(getActivity());

        onSignIn();

        CheckBox cbAreYouAgree = (CheckBox) view.findViewById(R.id.cb_are_you_agree);
        Button btnSignUp = (Button) view.findViewById(R.id.btn_sign_up);


        btnSignUp.setOnClickListener(v -> {

            onSingUp();
        });
        return view;
    }

    private  String getTrimValue(EditText view) {
        return view.getText().toString().trim();
    }


    public void onSingUp() {
        EditText email1 = (EditText) view.findViewById(R.id.et_user_email);
        EditText pass1 = (EditText) view.findViewById(R.id.et_user_password);

        User user = new User();
        String userName = getTrimValue(view.findViewById(R.id.et_user_name));
        String email = getTrimValue(view.findViewById(R.id.et_user_email));
        String password = getTrimValue(view.findViewById(R.id.et_user_password));
        String passwordConf = getTrimValue(view.findViewById(R.id.et_user_repeat_password));

        if (password.equals(passwordConf)) {
            user.setUserName(userName);
            user.setEmail(email);
            user.setPassword(password);
            long val = db.addUser(user);
            if (val > 0) {
                Toast.makeText(getActivity(), "You have registered", Toast.LENGTH_SHORT).show();
                Intent HomePage = new Intent(getActivity(), MainScreenActivity.class);
                Bundle b = new Bundle();
                b.putString("email", email1.getText().toString());
                b.putString("password", pass1.getText().toString());

                String y = db.selectOneUserSendUserName(email, password);
                int x = db.selectOneUserSendId(email,password);
                Log.d("TAG" , "ID =  " + x);

                b.putString("textViewUsername",y);
                b.putString("textViewId", String.valueOf(x));

                HomePage.putExtras(b);
                startActivity(HomePage);


                } else
                    Toast.makeText(getActivity(), "Registeration Error", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Password is not matching", Toast.LENGTH_SHORT).show();
            }
        }


public void onSignIn(){
    TextView tvsigninsignup = (TextView) view.findViewById(R.id.tv_sign_in_sign_up);
        tvsigninsignup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getFragmentManager().getBackStackEntryCount() > 0) {
                getFragmentManager().popBackStackImmediate();
            } else if (listener != null) {
                listener.onRout("sign in");
            }
        }
        });
    }
}


