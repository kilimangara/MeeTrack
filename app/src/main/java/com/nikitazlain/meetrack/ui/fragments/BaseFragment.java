package com.nikitazlain.meetrack.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nikitazlain.meetrack.layoutBinder.Arguments;
import com.nikitazlain.meetrack.layoutBinder.Layout;
import com.nikitazlain.meetrack.presenters.BasePresenter;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

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
        for(Field field: clazz.getFields()){
            if(field.isAnnotationPresent(Arguments.class)){
                field.setAccessible(true);
                Arguments argument = field.getAnnotation(Arguments.class);
                try {
                    switch (field.getType().getSimpleName()) {
                        case "String":
                            field.set(this, getArguments().getString(argument.key()));
                            break;
                        case "int":
                            field.set(this, getArguments().getInt(argument.key()));
                            break;
                        case "boolean":
                            field.set(this, getArguments().getBoolean(argument.key()));
                            break;
                    }
                } catch (IllegalAccessException e){
                    Log.e("Arguments injection", e.getLocalizedMessage());
                }
            }
        }
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
