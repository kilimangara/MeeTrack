package com.nikitazlain.meetrack.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikitazlain.meetrack.layoutBinder.Layout;
import com.nikitazlain.meetrack.presenters.BasePresenter;

import java.lang.annotation.Annotation;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Class clazz = getClass();
        if(!clazz.isAnnotationPresent(Layout.class)) throw new RuntimeException("No layout id");
        Annotation annotation = clazz.getAnnotation(Layout.class);
        Layout layout =(Layout) annotation;
        View view = inflater.inflate(layout.id(),container, false);
        unbinder= ButterKnife.bind(this, view);
        return view;
    }

    public abstract BasePresenter getPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
