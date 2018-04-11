package com.example.devsk.jobpf;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {


    private static JobApi jobApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder().
                baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jobApi = retrofit.create(JobApi.class);
    }
    public static JobApi getJobApi(){
        return jobApi;
    }
}
