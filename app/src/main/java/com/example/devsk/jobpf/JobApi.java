package com.example.devsk.jobpf;

import com.example.devsk.jobpf.modelcompanies.CompaniesModel;
import com.example.devsk.jobpf.modelnews.NewsModel;
import com.example.devsk.jobpf.modelsvacancy.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JobApi {

    @GET("bins/1cleju")
    Call<Model> getJob();
    @GET("bins/r16q2")
    Call<NewsModel> getNews();
    @GET("/bins/medjy")
    Call<CompaniesModel> getCompanies();
}
