package com.nikitazlain.meetrack.LoginFragments;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nikitok.metrack.R;
import com.nikitazlain.meetrack.LoginActivity;
import com.nikitazlain.meetrack.entity.ErrorResponse;
import com.nikitazlain.meetrack.layoutBinder.Layout;
import com.nikitazlain.meetrack.presenters.BasePresenter;
import com.nikitazlain.meetrack.presenters.LoginPresenter;
import com.nikitazlain.meetrack.ui.fragments.BaseFragment;
import com.nikitazlain.meetrack.views.LoginViews;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
@Layout(id =R.layout.fragment_code)

public class CodeFragment extends BaseFragment implements LoginViews {
    @BindView(R.id.confirmCode)
    EditText edCode;
    @BindView(R.id.label1)
    TextView tvLabel;

    String phone;

    public CodeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_code, container, false);
        phone = getArguments().getString(LoginActivity.PHONE_KEY);
        final TextView tvlabel = (TextView) view.findViewById(R.id.label1);
        final TextView tvResend = (TextView) view.findViewById(R.id.resend);
        edCode = (EditText) view.findViewById(R.id.confirmCode);
        new CountDownTimer(30000, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                tvlabel.setText("You can resend code:"+millisUntilFinished/1000+" seconds");
            }

            @Override
            public void onFinish() {
                tvlabel.setVisibility(View.GONE);
                tvResend.setVisibility(View.VISIBLE);
            }
        }.start();
        return view;
    }

    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void showError(ErrorResponse error) {

    }

    @Override
    public void showSnackbar(String notify) {

    }
}
