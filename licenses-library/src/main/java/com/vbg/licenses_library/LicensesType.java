package com.vbg.licenses_library;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by victo on 14/10/2017.
 */

public abstract class LicensesType {

    public static final int MIT = 0;
    public static final int BSD2 = 1;
    public static final int BSD3 = 2;
    public static final int APACHE20 = 3;
    public static final int CC30 = 4;        // Creative Commons 3.0 License

    @IntDef({MIT, BSD2, BSD3, APACHE20, CC30})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LicenseType {
    }
}
