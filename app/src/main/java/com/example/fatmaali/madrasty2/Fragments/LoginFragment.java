package com.example.fatmaali.madrasty2.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fatmaali.madrasty2.Activities.CustomNavActivity;
import com.example.fatmaali.madrasty2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    View view;
    TextView textViewLogin, textViewRegistration;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_login, container, false);
        textViewLogin = (TextView) view.findViewById(R.id.Login);
        textViewRegistration = (TextView) view.findViewById(R.id.registration);
        init();
        return view;
    }

    public void init() {
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent CustomIntent = new Intent(getActivity(), CustomNavActivity.class);
                startActivity(CustomIntent);
            }
        });
        textViewRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frameLoginReg, new RegFragment()).addToBackStack(null).commit();
            }
        });
    }

}
