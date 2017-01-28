package com.nikitazlain.meetrack.LoginFragments;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikitok.metrack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneFragment extends Fragment {
    private String phone;
    private  TextInputLayout edPhone;

    public PhoneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone, container, false);
        edPhone = (TextInputLayout) view.findViewById(R.id.phone);
        return view;
    }

    public String getPhone(){
        return phone;
    }


}
