
package com.example.devsk.jobpf.modelcompanies;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Logo implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("url")
    @Expose
    private String url;
    public final static Parcelable.Creator<Logo> CREATOR = new Creator<Logo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Logo createFromParcel(Parcel in) {
            return new Logo(in);
        }

        public Logo[] newArray(int size) {
            return (new Logo[size]);
        }

    }
    ;

    protected Logo(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Logo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(url);
    }

    public int describeContents() {
        return  0;
    }

}
