package com.nikitazlain.meetrack.interactors;

import com.nikitazlain.meetrack.entity.BaseResponse;
import com.nikitazlain.meetrack.entity.Info;
import com.nikitazlain.meetrack.entity.User;
import com.nikitazlain.meetrack.entity.request.LoginInfo;
import com.nikitazlain.meetrack.providers.LoginProvider;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class SendCodeInteractor extends BaseInteractor<LoginInfo, BaseResponse<Info>> {
    public SendCodeInteractor() {
        super(AndroidSchedulers.mainThread(), Schedulers.computation());
    }

    @Override
    public Observable<BaseResponse<Info>> buildObservable(LoginInfo loginInfo) {

        return LoginProvider.authUser(loginInfo.getPhone(), loginInfo.getCode());
    }
}
