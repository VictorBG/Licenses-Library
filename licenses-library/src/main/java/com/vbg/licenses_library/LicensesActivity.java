package com.vbg.licenses_library;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.ColorRes;
import android.support.annotation.IntDef;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.LinearLayout;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;

/**
 * Created by victo on 14/10/2017.
 */

public abstract class LicensesActivity extends AppCompatActivity {


    public static final int DARK = 1;
    public static final int LIGHT = 2;

    @IntDef({DARK, LIGHT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LicensesStyle {
    }

    private int activityStyle = DARK;

    Toolbar toolbar;
    LinearLayout licensesLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        if (getActivityStyle() == DARK) {
            setTheme(R.style.LicensesDarkTheme);
        } else {
            setTheme(R.style.LicensesLightTheme);
        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.licenses_activity);

        toolbar = findViewById(R.id.lb_toolbar);
        licensesLayout = findViewById(R.id.lb_licenses_container_activity);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        activityStyle = getActivityStyle();

        if (setupLicenses() != null) {
            licensesLayout.addView(setupLicenses().build(activityStyle).getLicensesView());
        }

    }

    public LicensesLibrary.Builder setupLicenses() {
        return null;
    }

    public void setLicenses(@NonNull LicensesLibrary.Builder licenses) {
        licensesLayout.removeAllViews();
        licensesLayout.addView(licenses.build(activityStyle).getLicensesView());
        licensesLayout.postInvalidate();
    }

    public abstract @LicensesStyle
    int getActivityStyle();


    private void colorStatusBar(@ColorRes int color) {
        final Window window = getWindow();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //API 21+
            window.setStatusBarColor(getResources().getColor(color));
        } else {
            SystemBarTintManager tintManager = new SystemBarTintManager(LicensesActivity.this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setNavigationBarTintEnabled(true);
            tintManager.setTintColor(getResources().getColor(color));
        }
    }

    @Override
    public void onBackPressed() {
        supportFinishAfterTransition();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
