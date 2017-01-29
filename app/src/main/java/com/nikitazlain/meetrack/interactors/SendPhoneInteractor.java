package com.nikitazlain.meetrack.interactors;

import com.google.gson.JsonObject;
import com.nikitazlain.meetrack.entity.BaseResponse;
import com.nikitazlain.meetrack.entity.Info;
import com.nikitazlain.meetrack.entity.request.LoginInfo;
import com.nikitazlain.meetrack.providers.LoginProvider;

import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by nikitazlain on 29.01.17.
 */

public class SendPhoneInteractor extends BaseInteractor<LoginInfo, BaseResponse<JsonObject>> {

    public SendPhoneInteractor() {
        super(AndroidSchedulers.mainThread(), Schedulers.computation());
    }

    @Override
    public Observable<BaseResponse<JsonObject>> buildObservable(LoginInfo loginInfo) {
        return LoginProvider.sendPhone(loginInfo.getPhone());
    }
}
