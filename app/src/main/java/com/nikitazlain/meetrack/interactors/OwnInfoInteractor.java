package com.nikitazlain.meetrack.interactors;

import com.nikitazlain.meetrack.entity.BaseResponse;
import com.nikitazlain.meetrack.entity.User;
import com.nikitazlain.meetrack.providers.UserProvider;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;



public class OwnInfoInteractor extends BaseInteractor<String, BaseResponse<User>> {

    public OwnInfoInteractor() {
        super(AndroidSchedulers.mainThread(), Schedulers.computation());
    }

    @Override
    public Observable<BaseResponse<User>> buildObservable(String token) {

        return UserProvider.getMe(token);
    }
}
