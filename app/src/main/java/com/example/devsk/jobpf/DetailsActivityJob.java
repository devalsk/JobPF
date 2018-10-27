package com.example.devsk.jobpf;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.devsk.jobpf.modelsvacancy.Vacancy;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class DetailsActivityJob extends AppCompatActivity {

    Vacancy vacancy;
    TextView headerView, zpView, adressView, companyView, trebView, descriptiveView, telefonView, emailView;
    String header, zp, adress, bilding, company, treb, descriptive, telefon, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_job);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        headerView = findViewById(R.id.t_name_prof);
        zpView = findViewById(R.id.t_zp);
        adressView = findViewById(R.id.t_adress);
        companyView = findViewById(R.id.t_company);
        trebView = findViewById(R.id.t_treb_data);
        descriptiveView = findViewById(R.id.t_treb_data2);
        telefonView = findViewById(R.id.t_telefon);
        emailView = findViewById(R.id.t_email);


        Intent intentTheStartedActivity = getIntent();
        if (intentTheStartedActivity.hasExtra("data")) {
            vacancy = getIntent().getParcelableExtra("data");
            //Log.d("fl",vacancy.getZpMin());
            header =vacancy.getHeader();
            zp = vacancy.getZpMin();
            adress = vacancy.getContact().getStreet();
            bilding = vacancy.getContact().getBilding();
            company = vacancy.getCompany().getTitle();
            treb = vacancy.getDemands();
            descriptive = vacancy.getDescriptive();
            telefon = vacancy.getContact().getPhone();
            email = vacancy.getContact().getEmail();


            headerView.setText(header);
            zpView.setText(zp + " руб.");
            adressView.setText(adress + " " + bilding);
            companyView.setText(company);
            trebView.setText(Html.fromHtml("<br>" +treb));
            descriptiveView.setText(Html.fromHtml(descriptive));
            telefonView.setText(telefon);
            emailView.setText(email);


        } else {
            Toast.makeText(this, "No Api", Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details_activity,menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.share:
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Click Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "http");
                startActivity(Intent.createChooser(sharingIntent,"Отправить вакансию"));
                return true;
            case R.id.saveDataBase:
                Realm.init(this);
                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                RealmTest realmTest = realm.createObject(RealmTest.class);
                realmTest.setName("Ivan");
                realm.commitTransaction();
                Realm.getInstance(new RealmConfiguration.Builder().build());
                return  true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickTel(View v) {

        String toDial = "tel:" + telefon;
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));

    }

    public void onClickEmail(View v) {

      Intent intentEmail = new Intent(Intent.ACTION_SEND);
      intentEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
      intentEmail.putExtra(Intent.EXTRA_SUBJECT,"Вакансия " + header);
      intentEmail.setType("message/rfc822");
      startActivity(Intent.createChooser(intentEmail,"Выберите email клиент :"));

    }
    public void onClickMaps(View v){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:0,0?q=" + adress + bilding));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

}
