package com.brex.galangue.sampleweatherapp.helper.SharedPreferenceUtility;

import android.app.Activity;

import java.util.Map;

public class IntegerSharedPreferenceUtility extends BaseSharedPreference<Integer> {

    public IntegerSharedPreferenceUtility(Activity activity, String name) {
        super(activity, name);
    }

    @Override
    public void setValue(String key, Integer value) {
        getEditor().putInt(key, value);
        getEditor().apply();
    }

    @Override
    public void setValues(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            getEditor().putInt(entry.getKey(), entry.getValue());
        }
        getEditor().apply();
    }

    @Override
    public Integer getValue(String key) {
        return getSharedPreferences().getInt(key, 0);
    }

    @Override
    public Integer getValue(String key, Integer defaultValue) {
        return getSharedPreferences().getInt(key, defaultValue);
    }


}
