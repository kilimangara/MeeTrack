package com.nikitazlain.meetrack.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nikitazlain.meetrack.layoutBinder.Layout;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Class cls = getClass();
        if(!cls.isAnnotationPresent(Layout.class)) throw new RuntimeException("layout id annotation");
        Layout layout = (Layout) cls.getAnnotation(Layout.class);
        setContentView(layout.id());
        unbinder = ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
