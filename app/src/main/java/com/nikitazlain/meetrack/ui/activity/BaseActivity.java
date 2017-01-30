package com.nikitazlain.meetrack.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.nikitazlain.meetrack.layoutBinder.Layout;
import com.nikitazlain.meetrack.layoutBinder.Presenter;
import com.nikitazlain.meetrack.presenters.BasePresenter;
import com.nikitazlain.meetrack.ui.fragments.BaseFragment;

import java.lang.reflect.Field;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    private Unbinder unbinder;

    protected BasePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Class cls = getClass();
        if(!cls.isAnnotationPresent(Layout.class)|| !cls.isAnnotationPresent(Presenter.class)) throw new RuntimeException("layout id annotation");
        Layout layout = (Layout) cls.getAnnotation(Layout.class);
        setContentView(layout.id());
        Presenter presenter = (Presenter) cls.getAnnotation(Presenter.class);
        for(Field field: cls.getFields()){
            if(field.getName().equals("presenter")){
                field.setAccessible(true);
                try {
                    field.set(this, presenter.presenter().newInstance());
                } catch (IllegalAccessException e) {
                    Log.e("Presenter", e.getLocalizedMessage());
                } catch (InstantiationException e) {
                    Log.e("Presenter", e.getLocalizedMessage());
                }
                break;
            }
        }
        unbinder = ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public void resolveToolbar(BaseFragment fragment){

    }

    public BasePresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
    }
}
