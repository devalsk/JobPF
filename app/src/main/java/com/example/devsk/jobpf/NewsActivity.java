package com.example.devsk.jobpf;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.devsk.jobpf.modelnews.NewsModel;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List news;
    SpotsDialog dialog;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        news = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new SpaceItemDecoration(20));
        NewsAdapter newsAdapter = new NewsAdapter(news, this);
        recyclerView.setAdapter(newsAdapter);

        dialog = new SpotsDialog(this);
        dialog.show();
        App.getJobApiProfit().getNews().enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                // Log.d("fd",response.body().getNews().toString());
                NewsModel newsModel = response.body();
                news.addAll(newsModel.getNews());
                recyclerView.getAdapter().notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });


    }
}
