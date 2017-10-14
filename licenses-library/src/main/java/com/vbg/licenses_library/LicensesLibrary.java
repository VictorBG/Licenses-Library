package com.vbg.licenses_library;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vbg.licenses_library.utils.Themes;

import java.util.ArrayList;

/**
 * Created by victor on 14/10/2017.
 */


public class LicensesLibrary {

    Context context;
    View view;

    public LicensesLibrary() {

    }

    public LicensesLibrary(Context context) {
        this.context = context;
    }

    public void setView(View v) {
        this.view = v;
    }

    public View getLicensesView() {
        return view;
    }

    public static class Builder {


        private LinearLayout container;
        private ArrayList<License> licenses;
        private Context context;

        public Builder(Context context) {
            this.context = context;
            licenses = new ArrayList<>();
            container = (LinearLayout) Themes.inflateLayout(context, R.layout.licenses_container, null);
        }

        public Builder addLicense(License license) {
            licenses.add(license);
            return this;
        }

        public LicensesLibrary build(@LicensesActivity.LicensesStyle final int style) {
            LicensesLibrary licensesLibrary = new LicensesLibrary(context);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                    .LAYOUT_INFLATER_SERVICE);

            for (int i = 0; i < licenses.size(); i++) {
                View v = Themes.inflateLayout(inflater, R.layout.licenses_row, null);
                TextView title = v.findViewById(R.id.title);

                final License license = licenses.get(i);
                title.setText(license.getTitle());
                v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(context, LicenseDetailActivity.class);
                        i.putExtra(LicenseDetailActivity.LICENSE_BUNDLE_KEY, license);
                        i.putExtra(LicenseDetailActivity.LICENSE_BUNDLE_STYLE, style);
                        context.startActivity(i);
                    }
                });

                container.addView(v);
            }
            licensesLibrary.setView(container);
            return licensesLibrary;
        }
    }

}
