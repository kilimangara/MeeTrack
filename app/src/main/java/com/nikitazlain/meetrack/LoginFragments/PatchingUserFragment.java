package com.nikitazlain.meetrack.LoginFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikitok.metrack.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatchingUserFragment extends Fragment {


    public PatchingUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patching_user, container, false);
    }

}
