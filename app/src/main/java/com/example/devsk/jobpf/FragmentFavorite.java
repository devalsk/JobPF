package com.example.devsk.jobpf;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.nio.file.Files;

import io.realm.Realm;


public class FragmentFavorite extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Realm.init(getContext());
        Realm realm = Realm.getDefaultInstance();
        RealmTest realmTest = realm.where(RealmTest.class).findFirst();

        View view = inflater.inflate(R.layout.fragmentfavorite, container, false);


        final TextView name = (TextView) view.findViewById(R.id.fest);

        name.setText(realmTest.getName());
        return view;


    }
}