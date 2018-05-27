
package com.example.devsk.jobpf.modelcompanies;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact implements Parcelable
{

    @SerializedName("street")
    @Expose
    private String street;
    @SerializedName("bilding")
    @Expose
    private String bilding;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("email")
    @Expose
    private String email;
    public final static Parcelable.Creator<Contact> CREATOR = new Creator<Contact>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {
            return (new Contact[size]);
        }

    }
    ;

    protected Contact(Parcel in) {
        this.street = ((String) in.readValue((String.class.getClassLoader())));
        this.bilding = ((String) in.readValue((String.class.getClassLoader())));
        this.phone = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Contact() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBilding() {
        return bilding;
    }

    public void setBilding(String bilding) {
        this.bilding = bilding;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(street);
        dest.writeValue(bilding);
        dest.writeValue(phone);
        dest.writeValue(email);
    }

    public int describeContents() {
        return  0;
    }

}
