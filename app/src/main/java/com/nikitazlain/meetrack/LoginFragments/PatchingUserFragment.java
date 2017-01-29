package com.nikitazlain.meetrack.LoginFragments;


import android.support.v4.app.Fragment;

import com.example.nikitok.metrack.R;
import com.nikitazlain.meetrack.layoutBinder.Layout;
import com.nikitazlain.meetrack.presenters.BasePresenter;
import com.nikitazlain.meetrack.ui.fragments.BaseFragment;
import com.nikitazlain.meetrack.views.LoginViews;

/**
 * A simple {@link Fragment} subclass.
 */
@Layout(id = R.layout.fragment_patching_user)
public class PatchingUserFragment extends BaseFragment implements LoginViews {


    public PatchingUserFragment() {
        // Required empty public constructor
    }


    @Override
    public BasePresenter getPresenter() {
        return null;
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void showSnackbar(String notify) {

    }
}
