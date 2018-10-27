package com.example.devsk.jobpf;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {


    private static JobApi jobApi;
    private Retrofit retrofit;
    private Retrofit retrofitProfit;
    private static JobApi jobApiProfit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jobApi = retrofit.create(JobApi.class);


        retrofitProfit = new Retrofit.Builder()
                .baseUrl("http://profit-altstu.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jobApiProfit = retrofitProfit.create(JobApi.class);

    }

    public static JobApi getJobApi() {
        return jobApi;
    }

    public static JobApi getJobApiProfit() {
        return jobApiProfit;

    }
}
