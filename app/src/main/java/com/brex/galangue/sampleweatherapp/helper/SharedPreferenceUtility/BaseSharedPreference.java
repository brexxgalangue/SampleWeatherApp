package com.brex.galangue.sampleweatherapp.helper.SharedPreferenceUtility;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

public abstract class BaseSharedPreference<T> {

    private Activity activity;
    private String name;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public BaseSharedPreference(Activity activity, String name) {
        this.activity           = activity;
        this.name               = name;
        this.sharedPreferences  = this.activity.getSharedPreferences(name, Context.MODE_PRIVATE);
        this.editor             = this.sharedPreferences.edit();
    }

    public Activity getActivity() {
        return activity;
    }

    public String getName() {
        return name;
    }

    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public void clear() {
        this.editor.clear();
        this.editor.apply();
    }

    public abstract void setValue(String key, T value);
    public abstract void setValues(Map<String, T> map);
    public abstract T getValue(String key);
    public abstract T getValue(String key, T defaultValue);

}
