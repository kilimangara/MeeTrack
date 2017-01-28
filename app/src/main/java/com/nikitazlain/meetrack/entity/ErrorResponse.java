package com.nikitazlain.meetrack.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nikitazlain on 28.01.17.
 */

public class ErrorResponse {

    @SerializedName("error-code")
    @Expose
    private int code;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("description")
    @Expose
    private String description;

    public int getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
