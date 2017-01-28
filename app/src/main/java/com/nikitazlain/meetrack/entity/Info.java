package com.nikitazlain.meetrack.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Info {
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("token")
    @Expose
    private String token;

    /**
     *
     * @return
     * The userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(String token) {
        this.token = token;
    }

}
