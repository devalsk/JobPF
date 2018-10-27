package com.example.devsk.jobpf;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailProjectActivity extends AppCompatActivity {

    String emails;
    ImageView imageView;
    TextView nameProject,desc,author,gitRepo,contactEmail,gitAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_project);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        nameProject = findViewById(R.id.name_project);
        desc = findViewById(R.id.data_desc);
        author = findViewById(R.id.dat_author);
        gitRepo = findViewById(R.id.dat_github_repo);
        contactEmail = findViewById(R.id.data_email);
        gitAccount = findViewById(R.id.dat_git_account);
        imageView = findViewById(R.id.card_image);


        String img = getIntent().getStringExtra("img");
        String nameProjects = getIntent().getStringExtra("name");
        String descs = getIntent().getStringExtra("desc");
        String authors = getIntent().getStringExtra("author");
        String getRepos = getIntent().getStringExtra("gitRepo");
        emails = getIntent().getStringExtra("email");
        String gitAccounts = getIntent().getStringExtra("gitaccount");


        Picasso.get().load(img).into(imageView);
        nameProject.setText(nameProjects);
        desc.setText(descs);
        author.setText(authors);
        contactEmail.setText(emails);







        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "Заявка отправлена", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    public  void onClickGit(View v){
        Uri address = Uri.parse("https://github.com/devalsk/site-project1");
        Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openlinkIntent);
    }
    public  void onClickEmail(View v){

        Intent intentEmail = new Intent(Intent.ACTION_SEND);
        intentEmail.putExtra(Intent.EXTRA_EMAIL,new String[]{emails});
        intentEmail.setType("message/rfc822");
        startActivity(Intent.createChooser(intentEmail,"Выберите email клиент :"));


    }
    public  void onClickGitAc(View v){
        Uri address = Uri.parse("https://github.com/devalsk");
        Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
        startActivity(openlinkIntent);
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
                startActivity(Intent.createChooser(sharingIntent,"Отправить проект"));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_details_activity,menu);
        return true;

    }
}
