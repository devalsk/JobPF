
package com.example.devsk.jobpf.modelcompanies;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("official_title")
    @Expose
    private String officialTitle;
    @SerializedName("logo")
    @Expose
    private Logo logo;
    @SerializedName("descriptive")
    @Expose
    private String descriptive;
    @SerializedName("rubrics")
    @Expose
    private String rubrics;
    @SerializedName("employees")
    @Expose
    private String employees;
    @SerializedName("contact")
    @Expose
    private Contact contact;
    public final static Parcelable.Creator<Company> CREATOR = new Creator<Company>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Company createFromParcel(Parcel in) {
            return new Company(in);
        }

        public Company[] newArray(int size) {
            return (new Company[size]);
        }

    }
    ;

    protected Company(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.officialTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.logo = ((Logo) in.readValue((Logo.class.getClassLoader())));
        this.descriptive = ((String) in.readValue((String.class.getClassLoader())));
        this.rubrics = ((String) in.readValue((String.class.getClassLoader())));
        this.employees = ((String) in.readValue((String.class.getClassLoader())));
        this.contact = ((Contact) in.readValue((Contact.class.getClassLoader())));
    }

    public Company() {
    }

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

    public String getOfficialTitle() {
        return officialTitle;
    }

    public void setOfficialTitle(String officialTitle) {
        this.officialTitle = officialTitle;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }

    public String getDescriptive() {
        return descriptive;
    }

    public void setDescriptive(String descriptive) {
        this.descriptive = descriptive;
    }

    public String getRubrics() {
        return rubrics;
    }

    public void setRubrics(String rubrics) {
        this.rubrics = rubrics;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(date);
        dest.writeValue(officialTitle);
        dest.writeValue(logo);
        dest.writeValue(descriptive);
        dest.writeValue(rubrics);
        dest.writeValue(employees);
        dest.writeValue(contact);
    }

    public int describeContents() {
        return  0;
    }

}
