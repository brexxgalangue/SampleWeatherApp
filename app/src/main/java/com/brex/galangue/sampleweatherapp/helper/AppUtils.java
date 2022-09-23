package com.brex.galangue.sampleweatherapp.helper;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppUtils {

    public static void loadImageWithGlide(Context context, String url, ImageView img) {
        Glide.with(context)
                .load(url)
                .dontAnimate()
                .into(img);
    }

    public static String formatDateTime(String dateTime){
        String output = "";
        try{
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US);
            SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm aaa", Locale.US);
            Date input = inputFormat.parse(dateTime);
            output =outputFormat.format(input);
        }catch (Exception e){
            Log.e("errorTime", e.getMessage());
        }

        return output;
    }

    public static float convertToCelcius(String fahrenheit) {
        return (Math.round((Float.valueOf(fahrenheit).floatValue() - 275.15)));
    }
}
