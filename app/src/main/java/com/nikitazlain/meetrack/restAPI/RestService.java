package com.nikitazlain.meetrack.restAPI;


import com.google.gson.JsonObject;
import com.nikitazlain.meetrack.entity.BaseResponse;
import com.nikitazlain.meetrack.entity.Info;
import com.nikitazlain.meetrack.entity.User;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface RestService {

    @FormUrlEncoded
    @POST("auth/code/")
    Observable<BaseResponse<JsonObject>> sendCode(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("auth/users/")
    Observable<BaseResponse<Info>> authUser(@Field("phone") String phone, @Field("code") long code );

    @FormUrlEncoded
    @POST("auth/users/")
    Observable<BaseResponse<Info>> registerUser(@Field("phone") String phone, @Field("code") long code, @Field("name") String name);

    @GET("/api/account/")
    Observable<BaseResponse<User>> getOwnAccount(@Header("Authorization") String token);

}
