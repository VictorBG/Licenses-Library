package com.vbg.licenses_library;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by victo on 14/10/2017.
 */


public class License extends LicensesType implements Parcelable {

    private String title, year, owner;
    @LicenseType
    private int licenseType;
    private int idCustomLicense = -1;

    public License() {

    }

    public License(String title, int idCustomLicense) {
        this.title = title;
        this.idCustomLicense = idCustomLicense;
    }

    public License(String title, String owner, String year, @LicenseType int licenseType) {
        this.title = title;
        this.licenseType = licenseType;
        this.owner = owner;
        this.year = year;
    }

    protected License(Parcel in) {
        title = in.readString();
        year = in.readString();
        owner = in.readString();
        licenseType = in.readInt();
        idCustomLicense = in.readInt();
    }

    public static final Creator<License> CREATOR = new Creator<License>() {
        @Override
        public License createFromParcel(Parcel in) {
            return new License(in);
        }

        @Override
        public License[] newArray(int size) {
            return new License[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public @LicenseType
    int getLicenseType() {
        return licenseType;
    }

    public void setLicenseType(@LicenseType int licenseType) {
        this.licenseType = licenseType;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getIdCustomLicense() {
        return idCustomLicense;
    }

    public void setIdCustomLicense(int idCustomLicense) {
        this.idCustomLicense = idCustomLicense;
    }


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(year);
        parcel.writeString(owner);
        parcel.writeInt(licenseType);
        parcel.writeInt(idCustomLicense);
    }

}
