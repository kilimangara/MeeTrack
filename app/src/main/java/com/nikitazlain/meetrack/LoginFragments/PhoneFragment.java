package com.nikitazlain.meetrack.LoginFragments;


import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;

import com.example.nikitok.metrack.R;
import com.nikitazlain.meetrack.layoutBinder.Layout;
import com.nikitazlain.meetrack.presenters.BasePresenter;
import com.nikitazlain.meetrack.ui.fragments.BaseFragment;
import com.nikitazlain.meetrack.views.LoginViews;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */

@Layout(id =R.layout.fragment_phone)
public class PhoneFragment extends BaseFragment implements LoginViews {
    private String phone;
    @BindView(R.id.phone)
    private  TextInputLayout edPhone;

    public PhoneFragment() {
        // Required empty public constructor
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
