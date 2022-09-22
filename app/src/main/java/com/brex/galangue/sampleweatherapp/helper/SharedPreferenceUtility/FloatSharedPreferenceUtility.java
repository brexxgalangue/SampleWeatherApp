package com.brex.galangue.sampleweatherapp.helper.SharedPreferenceUtility;

import android.app.Activity;

import java.util.Map;

public class FloatSharedPreferenceUtility extends BaseSharedPreference<Float> {

    public FloatSharedPreferenceUtility(Activity activity, String name) {
        super(activity, name);
    }

    @Override
    public void setValue(String key, Float value) {
        getEditor().putFloat(key, value);
        getEditor().apply();
    }

    @Override
    public void setValues(Map<String, Float> map) {
        for (Map.Entry<String, Float> entry : map.entrySet()) {
            getEditor().putFloat(entry.getKey(), entry.getValue());
        }
        getEditor().apply();
    }

    @Override
    public Float getValue(String key) {
        return getSharedPreferences().getFloat(key, 0);
    }

    @Override
    public Float getValue(String key, Float defaultValue) {
        return getSharedPreferences().getFloat(key, defaultValue);
    }

}
