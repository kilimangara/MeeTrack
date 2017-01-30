package com.nikitazlain.meetrack.interactors;


import com.nikitazlain.meetrack.PreferenceHelper;
import com.nikitazlain.meetrack.entity.BaseResponse;
import com.nikitazlain.meetrack.entity.User;
import com.nikitazlain.meetrack.providers.UserProvider;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PatchInteractor extends BaseInteractor<User,BaseResponse<User>> {

    public PatchInteractor() {
        super(AndroidSchedulers.mainThread(), Schedulers.computation());
    }

    @Override
    public Observable<BaseResponse<User>> buildObservable(User user) {
        String token = PreferenceHelper.getInstance().getToken();
        Map<String, String> map = new HashMap<>();
        map.put("name",user.getName());
        map.put("hidden_phone", String.valueOf(user.getHiddenPhone()));
        return UserProvider.patchMe(token, map);
    }
}
