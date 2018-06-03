package com.example.fatmaali.madrasty2.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fatmaali.madrasty2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegFragment extends Fragment {
    View view;
    TextView textViewLogin;

    public RegFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_reg, container, false);
        textViewLogin = (TextView) view.findViewById(R.id.login);
        init();
        return view;
    }

    private void init() {
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().replace(R.id.frameLoginReg, new LoginFragment()).addToBackStack(null).commit();
            }
        });
    }

}
