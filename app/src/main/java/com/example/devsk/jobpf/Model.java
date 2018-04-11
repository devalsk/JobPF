package com.example.devsk.jobpf;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {
    public Model(int id, String nameProf, String zp, String company, String tr, String op, String tel, String email) {
        this.id = id;
        this.nameProf = nameProf;
        this.zp = zp;
        this.company = company;
        this.tr = tr;
        this.op = op;
        this.tel = tel;
        this.email = email;
    }

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("NameProf")
    @Expose
    private String nameProf;
    @SerializedName("zp")
    @Expose
    private String zp;
    @SerializedName("Company")
    @Expose
    private String company;
    @SerializedName("Tr")
    @Expose
    private String tr;
    @SerializedName("op")
    @Expose
    private String op;
    @SerializedName("Tel")
    @Expose
    private String tel;
    @SerializedName("email")
    @Expose
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProf() {
        return nameProf;
    }

    public void setNameProf(String nameProf) {
        this.nameProf = nameProf;
    }

    public String getZp() {
        return zp;
    }

    public void setZp(String zp) {
        this.zp = zp;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}