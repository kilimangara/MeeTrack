package com.nikitazlain.meetrack.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nikitazlain on 28.01.17.
 */

public class BaseResponse<T> {

    @SerializedName("data")
    @Expose
    private T data;
    @SerializedName("error")
    @Expose
    private ErrorResponse error;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
