package com.nikitazlain.meetrack.interactors;

import com.nikitazlain.meetrack.entity.BaseResponse;
import com.nikitazlain.meetrack.entity.Info;
import com.nikitazlain.meetrack.entity.request.LoginInfo;
import com.nikitazlain.meetrack.providers.LoginProvider;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegisterInteractor extends BaseInteractor<LoginInfo, BaseResponse<Info>> {

    public RegisterInteractor() {
        super(AndroidSchedulers.mainThread(), Schedulers.computation());
    }

    @Override
    public Observable<BaseResponse<Info>> buildObservable(LoginInfo user) {
        return LoginProvider.registerUser(user.getPhone(), user.getCode(), user.getName());
    }
}
