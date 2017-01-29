package com.nikitazlain.meetrack.LoginFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nikitok.metrack.R;
import com.nikitazlain.meetrack.layoutBinder.Layout;

/**
 * A simple {@link Fragment} subclass.
 */
@Layout(id =R.layout.fragment_creating_user_frament)
public class CreatingUserFrament extends Fragment {


    public CreatingUserFrament() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creating_user_frament, container, false);
    }

}
