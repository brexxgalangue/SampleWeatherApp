package com.brex.galangue.sampleweatherapp.helper.SharedPreferenceUtility;

import android.app.Activity;

import java.util.Map;

public class StringSharedPreferenceUtility extends BaseSharedPreference<String> {

    public StringSharedPreferenceUtility(Activity activity, String name) {
        super(activity, name);
    }

    @Override
    public void setValue(String key, String value) {
        getEditor().putString(key, value);
        getEditor().apply();
    }

    @Override
    public void setValues(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            getEditor().putString(entry.getKey(), entry.getValue());
        }
        getEditor().apply();
    }

    @Override
    public String getValue(String key, String defaultValue) {
        return getSharedPreferences().getString(key, defaultValue);
    }

    @Override
    public String getValue(String key) {
        return getValue(key, "");
    }
}
