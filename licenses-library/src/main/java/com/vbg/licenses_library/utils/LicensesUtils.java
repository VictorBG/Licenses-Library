package com.vbg.licenses_library.utils;

import android.content.Context;
import android.support.annotation.StringRes;

import com.vbg.licenses_library.License;
import com.vbg.licenses_library.R;

import static com.vbg.licenses_library.LicensesType.*;

/**
 * Created by VictorBG on 14/10/2017.
 */

public class LicensesUtils {

    public static String getLicenseDescription(Context context, License license) {

        if (license.getIdCustomLicense() != -1) {
            return context.getResources().getString(license.getIdCustomLicense());
        }

        int id = -1;
        switch (license.getLicenseType()) {
            case MIT:
                id = R.string.mit_license;
                break;
            case APACHE20:
                id = R.string.apache_2_0_license;
                break;
            case BSD2:
                id = R.string.bsd2_license;
                break;
            case CC30:
                id = R.string.cc30_license;
                break;
            case BSD3:
                id = R.string.bsd3_license;
                break;
        }
        return (id == -1) ? "" : buildLicense(context, id, license.getOwner(), license.getYear());
    }

    private static String buildLicense(Context context, @StringRes int id, String owner, String year) {
        String result = context.getResources().getString(id);

        result = result.replace("<<<OWNER>>>", owner);
        result = result.replace("<<<YEAR>>>", year);

        //result = result.replace("<<<", "");
        //result = result.replace(">>>", "");
        return result;
    }
}