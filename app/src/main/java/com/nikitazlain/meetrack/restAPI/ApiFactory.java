package com.nikitazlain.meetrack.restAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;



public class ApiFactory {
    private static final String BASE_URL = "http://46.101.218.49:8000/api/";
    private static ApiFactory instance;
    private Gson gson;
    private RestService service;


    private ApiFactory(){
    }

    public static ApiFactory getInstance(){
        if(instance== null){
            instance = new ApiFactory();
        }
        return instance;
    }

    public void init(){
        gson = new GsonBuilder().setPrettyPrinting().create();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        service = retrofit.create(RestService.class);
    }
    public RestService getService(){
        return service;
    }
    public Gson getGson(){
        return gson;
    }
}
