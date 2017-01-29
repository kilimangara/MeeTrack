package com.nikitazlain.meetrack.providers;


import com.google.gson.JsonObject;
import com.nikitazlain.meetrack.entity.BaseResponse;
import com.nikitazlain.meetrack.entity.Info;
import com.nikitazlain.meetrack.restAPI.ApiFactory;

import rx.Observable;

public class LoginProvider {

    public static Observable<BaseResponse<JsonObject>> sendPhone(String phone){
        return ApiFactory.getInstance().getService().sendCode(phone);
    }

    public static Observable<BaseResponse<Info>> authUser(String phone, long code){
        return ApiFactory.getInstance().getService().authUser(phone, code);
    }

    public static Observable<BaseResponse<Info>> registerUser(String phone, long code, String name){
        return ApiFactory.getInstance().getService().registerUser(phone, code, name);
    }
}
