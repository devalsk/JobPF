package com.example.devsk.jobpf;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JobApi {

    @GET("bins/bamq7")
    Call<List<Model>> getJob();


}
