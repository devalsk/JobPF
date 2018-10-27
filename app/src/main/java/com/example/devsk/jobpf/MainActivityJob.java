package com.example.devsk.jobpf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.devsk.jobpf.modelsvacancy.Model;
import com.example.devsk.jobpf.modelsvacancy.Vacancy;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivityJob extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView recyclerView;
    List<Vacancy> models;
    SpotsDialog dialog;
    Intent intent;
    MaterialSearchView materialSearchView;
    VacancyAdapter vacancyAdapter;
    Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_job);
        dialog = new SpotsDialog(this);
        dialog.show();
        models = new ArrayList<>();


        recyclerView = (RecyclerView) findViewById(R.id.rvlist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        vacancyAdapter = new VacancyAdapter(this, models);
        recyclerView.setAdapter(vacancyAdapter);


        App.getJobApi().getJob().enqueue(new Callback<Model>() {


            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {

                model = response.body();
                models.addAll(model.getVacancies());
                // Log.d("rr1",response.body().getVacancies().get(1).getHeader().toString());
                recyclerView.getAdapter().notifyDataSetChanged();
                dialog.dismiss();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {

            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        materialSearchView = findViewById(R.id.mysearch);
        materialSearchView.clearFocus();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_job, menu);
        MenuItem item = menu.findItem(R.id.search);
        materialSearchView.setMenuItem(item);
        materialSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
       @Override
       public boolean onQueryTextSubmit(String query) {
           return false;
       }

       @Override
       public boolean onQueryTextChange(String newText) {

           if (vacancyAdapter != null) vacancyAdapter.getFilter().filter(newText);
           return true;


       }
   });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {
           Intent intent = new Intent(this,CompanyListActivity.class);
           startActivity(intent);
        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(this,FavoritesActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_news) {
            intent = new Intent(this,NewsActivity.class);
            startActivity(intent);

        }else if (id == R.id.nav_project){
            intent = new Intent(this,ProjectActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
