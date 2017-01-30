package com.nikitazlain.meetrack.views;


import com.nikitazlain.meetrack.entity.ErrorResponse;

public interface LoginViews {

    void showError(ErrorResponse errorResponse);

    void showSnackbar(String notify);

}
