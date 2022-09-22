package com.brex.galangue.sampleweatherapp.helper.SharedPreferenceUtility;

import android.app.Activity;

public interface SharedPreferenceUtility<T> {

    void set(String key, T value);
    T get(String key, T defaultValue);

    class Factory {
        public static SharedPreferenceUtility getInstance(Activity activity, String name) {
            return new SharedPreferenceUtilityImpl(activity, name);
        }
    }
}
