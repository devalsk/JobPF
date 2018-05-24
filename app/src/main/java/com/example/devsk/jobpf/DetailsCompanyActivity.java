package com.example.devsk.jobpf;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.devsk.jobpf.modelcompanies.Company;
import com.squareup.picasso.Picasso;

public class DetailsCompanyActivity extends AppCompatActivity {

    Company company;
    TextView officialCompany,dataDetailCompany,dataEmail,dataAdress,dataTelefon;
    String logo,officalCompany,descriptiveText,email,adress,telf,bilding;
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_company);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        officialCompany = findViewById(R.id.official_company_detail);
        dataDetailCompany = findViewById(R.id.data_detail_company);
        dataEmail = findViewById(R.id.data_email);
        dataAdress = findViewById(R.id.data_adress);
        dataTelefon = findViewById(R.id.data_telefon);
        imgLogo = findViewById(R.id.img_view_detail);

        Intent intentDataCompany = getIntent();

        if (intentDataCompany.hasExtra("dataCompany")) {
            company = getIntent().getParcelableExtra("dataCompany");

            logo = company.getLogo().getUrl();
            Picasso.get().load(logo).into(imgLogo);
            officalCompany = company.getOfficialTitle();
            officialCompany.setText(officalCompany);
            descriptiveText = company.getDescriptive();
            dataDetailCompany.setText(descriptiveText);
            email = company.getContact().getEmail();
            dataEmail.setText(email);
            adress = company.getContact().getStreet();
            bilding = company.getContact().getBilding();
            dataAdress.setText(adress + bilding);
            telf = company.getContact().getPhone();
            dataTelefon.setText(telf);

        } else {

            //error

        }


    }


    public void onClickTel(View v) {

        String toDial = "tel:" + telf;
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));


    }
    public void onClickEmail(View v) {

        Intent intentEmail = new Intent(Intent.ACTION_SEND);
        intentEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{email});
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
}
