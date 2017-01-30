package com.nikitazlain.meetrack.injection;

import com.nikitazlain.meetrack.presenters.BasePresenter;

import java.util.HashSet;
import java.util.Set;

public class InjectionList {

    private static InjectionList instance;

    private Set<BasePresenter> presenterSet;

    public static InjectionList getInstance(){
        if(instance == null){
            instance = new InjectionList();
        }
        return instance;
    }

    public void init(){
        presenterSet = new HashSet<>();
    }

    public <T extends BasePresenter> T getPresenter(Class<T> presenterClass){
        for( BasePresenter presenter: presenterSet){
            if(presenter.getClass().getSimpleName().equals(presenterClass.getSimpleName())){
                return (T) presenter;
            }
        }
        return null;
    }

    public void addPresenter(Class<? extends BasePresenter> presenter) throws IllegalAccessException, InstantiationException {
        for(BasePresenter pres: presenterSet){
            if(presenter.getSimpleName().equals(pres.getClass().getSimpleName())){
                return;
            }
        }
        presenterSet.add(presenter.newInstance());
    }


}
