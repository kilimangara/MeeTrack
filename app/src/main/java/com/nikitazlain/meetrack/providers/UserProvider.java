package com.nikitazlain.meetrack.providers;



import com.nikitazlain.meetrack.entity.BaseResponse;
import com.nikitazlain.meetrack.entity.User;
import com.nikitazlain.meetrack.restAPI.ApiFactory;

import java.util.Map;

import rx.Observable;

public class UserProvider {

    public Observable<BaseResponse<User>> getMe(String token){
        return ApiFactory.getInstance().getService().getOwnAccount(token);
    }

    public Observable<BaseResponse<User>> patchMe(String token, Map<String, String> data){
        return ApiFactory.getInstance().getService().patchOwnAccount(token, data);
    }

}
