package com.example.devsk.jobpf.modelsvacancy;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Vacancy implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("header")
    @Expose
    private String header;
    @SerializedName("zp_min")
    @Expose
    private String zpMin;
    @SerializedName("zp_max")
    @Expose
    private String zpMax;
    @SerializedName("company")
    @Expose
    private Company company;
    @SerializedName("demands")
    @Expose
    private String demands;
    @SerializedName("descriptive")
    @Expose
    private String descriptive;
    @SerializedName("contact")
    @Expose
    private Contact contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getZpMin() {
        return zpMin;
    }

    public void setZpMin(String zpMin) {
        this.zpMin = zpMin;
    }

    public String getZpMax() {
        return zpMax;
    }

    public void setZpMax(String zpMax) {
        this.zpMax = zpMax;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDemands() {
        return demands;
    }

    public void setDemands(String demands) {
        this.demands = demands;
    }

    public String getDescriptive() {
        return descriptive;
    }

    public void setDescriptive(String descriptive) {
        this.descriptive = descriptive;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


    protected Vacancy(Parcel in) {
        id = in.readInt();
        date = in.readString();
        header = in.readString();
        zpMin = in.readString();
        zpMax = in.readString();
        company = (Company) in.readValue(Company.class.getClassLoader());
        demands = in.readString();
        descriptive = in.readString();
        contact = (Contact) in.readValue(Contact.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(date);
        dest.writeString(header);
        dest.writeString(zpMin);
        dest.writeString(zpMax);
        dest.writeValue(company);
        dest.writeString(demands);
        dest.writeString(descriptive);
        dest.writeValue(contact);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Vacancy> CREATOR = new Parcelable.Creator<Vacancy>() {
        @Override
        public Vacancy createFromParcel(Parcel in) {
            return new Vacancy(in);
        }

        @Override
        public Vacancy[] newArray(int size) {
            return new Vacancy[size];
        }
    };
}