package com.nikitazlain.meetrack.providers;



import com.nikitazlain.meetrack.entity.BaseResponse;
import com.nikitazlain.meetrack.entity.User;
import com.nikitazlain.meetrack.restAPI.ApiFactory;

import rx.Observable;

public class UserProvider {

    public Observable<BaseResponse<User>> getMe(String token){
        return ApiFactory.getInstance().getService().getOwnAccount(token);
    }


}
