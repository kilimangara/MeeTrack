package com.nikitazlain.meetrack.interactors;


import android.support.annotation.Nullable;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseInteractor<Parameter, Result> {
    private final CompositeSubscription subscription = new CompositeSubscription();

    private Scheduler jobScheduler;
    private Scheduler uiScheduler;

    public BaseInteractor(Scheduler job, Scheduler ui){
        this.uiScheduler = ui;
        this.jobScheduler = job;
    }

    public abstract Observable<Result> buildObservable(Parameter parameter);

    public void getData(Subscriber<Result> subscriber, @Nullable Parameter parameter){
        subscription.add(buildObservable(parameter)
        .subscribeOn(uiScheduler)
        .observeOn(jobScheduler)
        .subscribe(subscriber));
    }

    public void getData(Subscriber<Result> subscriber){
        getData(subscriber, null);
    }

    public void unsibscribe(){
        subscription.clear();
    }

}
