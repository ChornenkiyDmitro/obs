package com.example.splashscreen.FragmentysForRegistration;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class FragmentSignUp extends Fragment {


    String email, password, passwordConf;
    TextInputEditText email1, pass1, pass2;
    TextInputLayout emailError, passError, passConfError;
    CheckBox cbAreYouAgree;
    User user;
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

        Button btnSignUp = (Button) view.findViewById(R.id.btn_sign_up);


        btnSignUp.setOnClickListener(v -> {

            addNewUser();
        });
        return view;
    }

    private  String getTrimValue(TextInputEditText view) {
        return view.getText().toString().trim();
    }


    public void addNewUser() {

        if (onValidationCheck() == true) {
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
                int x = db.selectOneUserSendId(email, password);
                Log.d("TAG", "ID =  " + x);

                b.putString("textViewUsername", y);
                b.putString("textViewId", String.valueOf(x));

                HomePage.putExtras(b);
                startActivity(HomePage);


                if (getFragmentManager().getBackStackEntryCount() > 0) {
                    getFragmentManager().popBackStackImmediate();
                } else if (listener != null) {
                    listener.onRout("finish");
                }
            }
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



    private boolean onValidationCheck(){

        boolean flag = false;
        onTakingData();
        if (onFillFields() == true || onCheckBoxChecked() == true){
            if (onMatchPassword() == true || onCheckBoxChecked() == true){
                if (onCheckBoxChecked() == true) {
                    flag = true;
                }
            }
        }
        return flag;
    }


    private boolean onMatchPassword(){
        boolean flag = true;
        if (!password.equals(passwordConf)){
            passError.setError(" ");
            passConfError.setError("Password mismatch");
            flag = false;
        }

        return flag;
    }

private boolean onCheckBoxChecked(){
        boolean flag = true;
    if(!cbAreYouAgree.isChecked()){
        cbAreYouAgree.setButtonDrawable(R.drawable.checkbox_after_error);
        flag = false;
    }
    return flag;
}
private boolean onFillFields(){
        boolean flag = true;
    if(email.equals("")){
        emailError.setError("Fill  the field required");
        flag = false;
    }
    if (password.equals("")){
        passError.setError("Fill  the field required");
        flag = false;
    }
    if (passwordConf.equals("")){
        passConfError.setError("Fill  the field required");
        flag = false;
    }

    return  flag;
}



    private void onTakingData(){
        cbAreYouAgree = (CheckBox) view.findViewById(R.id.cb_are_you_agree);
        cbAreYouAgree.setButtonDrawable(R.drawable.toggle_checkbox);

        emailError = (TextInputLayout) view.findViewById(R.id.EmailError);
        passError = (TextInputLayout) view.findViewById(R.id.PasswordError);
        passConfError = (TextInputLayout) view.findViewById(R.id.PasswordRepeatError);
        emailError.setError(null);
        passError.setError(null);
        passConfError.setError(null);

         email1 = (TextInputEditText) view.findViewById(R.id.et_user_email);
         pass1 = (TextInputEditText) view.findViewById(R.id.et_user_password);
         pass2 = (TextInputEditText) view.findViewById(R.id.et_user_repeat_password);

         user = new User();
         email = getTrimValue(view.findViewById(R.id.et_user_email));
         password = getTrimValue(view.findViewById(R.id.et_user_password));
         passwordConf = getTrimValue(view.findViewById(R.id.et_user_repeat_password));
    }
}


