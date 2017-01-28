package com.nikitazlain.meetrack;


import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private static final String KEY_TOKEN="token";
    private static final String KEY_LOGED="loged";
    private static final String KEY_USER ="user";
    private static PreferenceHelper instance;

    private SharedPreferences preferences;
    private PreferenceHelper(){

    }

    public static PreferenceHelper getInstance(){
        if(instance == null){
            instance= new PreferenceHelper();
        }
        return instance;
    }
    public void init(Context context){
        preferences = context.getSharedPreferences("Prefs",Context.MODE_PRIVATE);
    }
    public void putToken(String token){
        String formatToken= "Token "+token;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(KEY_TOKEN, formatToken);
        editor.apply();
    }
    public String getToken(){
        return preferences.getString(KEY_TOKEN, "");
    }

    public void putLogged(boolean logged){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_LOGED, logged);
        editor.apply();
    }
    public boolean getLogged(){
        return preferences.getBoolean(KEY_LOGED,false);
    }

    public void putUser(String user){

    }
}
