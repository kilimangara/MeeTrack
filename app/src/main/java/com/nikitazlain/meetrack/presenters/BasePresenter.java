package com.nikitazlain.meetrack.presenters;


import com.nikitazlain.meetrack.interactors.BaseInteractor;

public abstract class BasePresenter<View, Router> {
    private View view;

    private Router router;

    public BaseInteractor interactor;

    public abstract void onStart();

    public abstract void onStop();

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public void switchInteractor(BaseInteractor interactor){
        this.interactor = interactor;
    }
}
