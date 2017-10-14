package com.vbg.licenses_library.utils;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by victo on 14/10/2017.
 */

public class Themes {

    public static View inflateLayout(LayoutInflater layoutInflater, @LayoutRes int layoutId, @Nullable ViewGroup root) {
        return layoutInflater.inflate(layoutId, root);
    }

    public static View inflateLayout(Context context, @LayoutRes int layoutId, @Nullable ViewGroup root) {
        return inflateLayout(LayoutInflater.from(context), layoutId, root);
    }
}
