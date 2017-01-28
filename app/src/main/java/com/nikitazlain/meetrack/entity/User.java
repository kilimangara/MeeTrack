package com.nikitazlain.meetrack.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("hidden_phone")
    @Expose
    private Boolean hiddenPhone;
    @SerializedName("avatar")
    @Expose
    private String avatar;
    @SerializedName("contacted")
    @Expose
    private Boolean contacted;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCreated() {
        return created;
    }

    public Boolean getHiddenPhone() {
        return hiddenPhone;
    }

    public String getAvatar() {
        return avatar;
    }

    public Boolean getContacted() {
        return contacted;
    }
}
