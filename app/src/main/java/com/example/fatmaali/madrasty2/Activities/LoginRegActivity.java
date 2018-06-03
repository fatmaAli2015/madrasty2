package com.example.fatmaali.madrasty2.Activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fatmaali.madrasty2.Fragments.LoginFragment;
import com.example.fatmaali.madrasty2.R;

public class LoginRegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_reg);
        LoginFragment loginFragment = new LoginFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLoginReg,loginFragment,loginFragment.getTag())
                .commit();
    }
}
