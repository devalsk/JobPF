package com.example.devsk.jobpf;

import io.realm.RealmObject;

public class RealmTest  extends RealmObject {

    private String name;

    public String getName() {
        return name;
    }

    public RealmTest() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmTest(String name) {

        this.name = name;
    }
}
