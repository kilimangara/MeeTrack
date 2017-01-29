package com.nikitazlain.meetrack.LoginFragments;


import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikitok.metrack.R;
import com.nikitazlain.meetrack.presenters.BasePresenter;
import com.nikitazlain.meetrack.ui.fragments.BaseFragment;
import com.nikitazlain.meetrack.views.LoginViews;

/**
 * A simple {@link Fragment} subclass.
 */


public class PhoneFragment extends BaseFragment implements LoginViews {
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

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    public String getPhone(){
        return phone;
    }


    @Override
    public void showError(String error) {

    }

    @Override
    public void showSnackbar(String notify) {

    }
}
