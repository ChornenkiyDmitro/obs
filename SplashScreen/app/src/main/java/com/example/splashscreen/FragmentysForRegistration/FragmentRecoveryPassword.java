package com.example.splashscreen.FragmentysForRegistration;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.splashscreen.DataBaseFile.DatabaseHelper;
import com.example.splashscreen.R;
import com.example.splashscreen.onFragmentChangeListener;
import com.google.android.material.textfield.TextInputLayout;

public class FragmentRecoveryPassword extends Fragment {

    TextInputLayout passError, passConfError;
    String passwordConf, password;
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


db = new DatabaseHelper(getActivity());
        view = inflater.inflate(R.layout.fragment_password_recovery_create, null);
        Button SavePassword = (Button) view.findViewById(R.id.btn_save_pass);
        SavePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });


        return view;
    }


    private  String getTrimValue(EditText view) {
        return view.getText().toString().trim();
    }

    public void changePassword() {

        Bundle bundle = getArguments();
        String email = bundle.getString("tag");


        passError = (TextInputLayout) view.findViewById(R.id.PasswordError_password_recovery);
        passConfError = (TextInputLayout) view.findViewById(R.id.PasswordError_password_recovery_repeat);
        passError.setError(null);
        passConfError.setError(null);

       password = getTrimValue(view.findViewById(R.id.et_rp_pass));
         passwordConf = getTrimValue(view.findViewById(R.id.et_rp_pass2));




        if (password.isEmpty() || passwordConf.isEmpty()) {
            if (password.equals("")){
                passError.setError( "Fill  the field required");
            }
            if (passwordConf.equals("")){
                passConfError.setError("Fill  the field required");
            }
            return;
        }

        if (!password.contentEquals(passwordConf)) {
            passError.setError(" ");
            passConfError.setError("Password mismatch");
            return;
        }

        else {

            db.updatePassword(email, password);
            Toast.makeText(getActivity(), "password reset successfully", Toast.LENGTH_SHORT).show();
            if (listener != null) {
                listener.onRout("sign in");
            }
        }
    }

}



