
package com.example.devsk.jobpf.modelcompanies;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompaniesModel implements Parcelable
{

    @SerializedName("companies")
    @Expose
    private List<Company> companies = null;
    public final static Parcelable.Creator<CompaniesModel> CREATOR = new Creator<CompaniesModel>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CompaniesModel createFromParcel(Parcel in) {
            return new CompaniesModel(in);
        }

        public CompaniesModel[] newArray(int size) {
            return (new CompaniesModel[size]);
        }

    }
    ;

    protected CompaniesModel(Parcel in) {
        in.readList(this.companies, (com.example.devsk.jobpf.modelcompanies.Company.class.getClassLoader()));
    }

    public CompaniesModel() {
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(companies);
    }

    public int describeContents() {
        return  0;
    }

}
