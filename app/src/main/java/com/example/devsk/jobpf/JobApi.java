package com.example.devsk.jobpf;

import com.example.devsk.jobpf.modelcompanies.CompaniesModel;
import com.example.devsk.jobpf.modelnews.NewsModel;
import com.example.devsk.jobpf.modelsvacancy.Model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JobApi {

    @GET("/bins/14xh2a")
    Call<Model> getJob();
    @GET("web/index.php?r=api/news")
    Call<NewsModel> getNews();
    @GET("/bins/medjy")
    Call<CompaniesModel> getCompanies();
}
