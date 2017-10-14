package com.vbg.licenses_library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;
import android.widget.Toast;

import com.vbg.licenses_library.utils.LicensesUtils;

/**
 * Created by victor on 14/10/2017.
 */

public class LicenseDetailActivity extends AppCompatActivity {

    public static final String LICENSE_BUNDLE_KEY = "LicenseObject";
    public static final String LICENSE_BUNDLE_STYLE = "LicensesStyle";

    @Override
    public void onCreate(Bundle savedInstanceState) {

        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getExtras().getInt(LICENSE_BUNDLE_STYLE) == LicensesActivity.DARK) {
                setTheme(R.style.LicensesDarkTheme);
            } else if (getIntent().getExtras().getInt(LICENSE_BUNDLE_STYLE) == LicensesActivity.LIGHT) {
                setTheme(R.style.LicensesLightTheme);
            }
        } else {
            throw new RuntimeException("Cannot create license detail activity with null extras");
        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.licenses_detail_activity);

        Toolbar toolbar = findViewById(R.id.lb_toolbar);
        TextView textView = findViewById(R.id.lb_description_license);


        License license = null;
        if (getIntent() != null && getIntent().getExtras() != null) {
            license = getIntent().getExtras().getParcelable(LICENSE_BUNDLE_KEY);
        }

        if (license == null) {
            Toast.makeText(this, R.string.license_get_error, Toast.LENGTH_SHORT).show();
            onBackPressed();
            return;
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(license.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView.setText(Html.fromHtml(LicensesUtils.getLicenseDescription(this, license)));


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

