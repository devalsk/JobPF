package com.example.devsk.jobpf;

import com.example.devsk.jobpf.models.Model;
import com.example.devsk.jobpf.models.Vacancy;

import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JobApi {

    @GET("bins/1f7hqq")
    Call<Model> getJob();


}
