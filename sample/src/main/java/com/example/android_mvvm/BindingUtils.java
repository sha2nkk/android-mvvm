package com.example.android_mvvm;

import android.databinding.BindingAdapter;
import android.view.View;

/**
 * Created by shashank on 12/7/16.
 */
public class BindingUtils {

    @BindingAdapter("android:visibility")
    public static void bindVisibilty(View view, Boolean visibility) {
        if(visibility == null || !visibility) {
            view.setVisibility(View.GONE);
        } else {
            view.setVisibility(View.VISIBLE);
        }
    }
}
