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
import androidx.fragment.app.FragmentManager;

import com.example.splashscreen.DataBaseFile.DatabaseHelper;
import com.example.splashscreen.R;
import com.google.android.material.textfield.TextInputLayout;

public class FragmentEmailVerifyForChangePassword extends Fragment {

    DatabaseHelper db;
    View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_password_recovery, null);
        Button btn_get_a_password = (Button) view.findViewById(R.id.btn_get_a_password);
        db = new DatabaseHelper(getActivity());
        btn_get_a_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCheck();
            }
        });
        return view;
    }

    public void onCheck() {

        TextInputLayout emailError = (TextInputLayout) view.findViewById(R.id.EmailError_password_recovery);
        emailError.setError(null);

        EditText editTextEmail = (EditText) view.findViewById(R.id.et_rp_email);
        String email = editTextEmail.getText().toString().trim();

        if (editTextEmail.getText().toString().isEmpty()) {
            emailError.setError("Fill  the field required");
        } else {
            if (db.checkUserEmailForChangePass(editTextEmail.getText().toString().trim())) {
                FragmentRecoveryPassword PasswordRecovery = new FragmentRecoveryPassword();
                Bundle bundle = new Bundle();
                bundle.putString("tag", email);
                PasswordRecovery.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_case, PasswordRecovery).commit();

            } else {
                emailError.setError("Wrong e-mail");
            }
        }
    }
}
