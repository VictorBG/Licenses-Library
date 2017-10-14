package com.vbg.licenseslibrary;


import com.vbg.licenses_library.License;
import com.vbg.licenses_library.LicensesActivity;
import com.vbg.licenses_library.LicensesLibrary;
import com.vbg.licenses_library.LicensesType;

public class MainActivity extends LicensesActivity {

    @Override
    public LicensesLibrary.Builder setupLicenses() {
        return new LicensesLibrary.Builder(this)
                .addLicense(new License("Android Open Source Project", "The Android Open Source Project", "2017", LicensesType.APACHE20))
                .addLicense(new License("Butter Knife", "Jake Wharton", "2013", LicensesType.APACHE20))
                .addLicense(new License("Gson", "Google Inc.", "2008", LicensesType.APACHE20))
                .addLicense(new License("ObservableScrollView", "Soichiro Kashima", "2014", LicensesType.APACHE20))
                .addLicense(new License("OkHttp", "Square, Inc.", "2016", LicensesType.BSD2))
                .addLicense(new License("Stetho", "Facebook, Inc.", "2015", LicensesType.BSD3))
                .addLicense(new License("Custom license", R.string.example_license));
    }

    @Override
    public int getActivityStyle() {
        return LIGHT;
    }
}
