package com.brex.galangue.sampleweatherapp.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class AppUtils {

    public static void loadImageWithGlide(Context context, String url, ImageView img) {
        Glide.with(context)
                .load(url)
                .dontAnimate()
                .into(img);
    }
}
