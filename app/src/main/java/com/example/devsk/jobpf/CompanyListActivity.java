package com.example.devsk.jobpf;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;

import com.example.devsk.jobpf.modelcompanies.CompaniesModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompanyListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List companies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);


        companies = new ArrayList<>();

        recyclerView = findViewById(R.id.companies_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        CompanyAdapter companyAdapter = new CompanyAdapter(companies, this);
        recyclerView.setAdapter(companyAdapter);
        App.getJobApi().getCompanies().enqueue(new Callback<CompaniesModel>() {
            @Override
            public void onResponse(Call<CompaniesModel> call, Response<CompaniesModel> response) {
                Log.d("dg",response.body().toString());
                CompaniesModel companiesModel  = response.body();
                companies.addAll(companiesModel.getCompanies());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CompaniesModel> call, Throwable t) {

            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
    }
}}
