package com.brex.galangue.sampleweatherapp.helper.SharedPreferenceUtility;

import android.app.Activity;

import java.util.Map;

public class BooleanSharedPreferenceUtility extends BaseSharedPreference<Boolean> {

    public BooleanSharedPreferenceUtility(Activity activity, String name) {
        super(activity, name);
    }

    @Override
    public void setValue(String key, Boolean value) {
        getEditor().putBoolean(key, value.booleanValue());
        getEditor().apply();
    }

    @Override
    public void setValues(Map<String, Boolean> map) {
        for (Map.Entry<String, Boolean> entry : map.entrySet()) {
            getEditor().putBoolean(entry.getKey(), entry.getValue().booleanValue());
        }
        getEditor().apply();
    }

    @Override
    public Boolean getValue(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

    @Override
    public Boolean getValue(String key, Boolean defaultValue) {
        return getSharedPreferences().getBoolean(key, defaultValue.booleanValue());
    }
}
