package com.brex.galangue.sampleweatherapp.helper.SharedPreferenceUtility;

import android.app.Activity;

class SharedPreferenceUtilityImpl implements SharedPreferenceUtility {
    private StringSharedPreferenceUtility stringSharedPreferenceUtility;
    private FloatSharedPreferenceUtility floatSharedPreferenceUtility;
    private BooleanSharedPreferenceUtility booleanSharedPreferenceUtility;
    private IntegerSharedPreferenceUtility integerSharedPreferenceUtility;

    public SharedPreferenceUtilityImpl(Activity activity, String name) {
        this.stringSharedPreferenceUtility  = new StringSharedPreferenceUtility(activity, name);
        this.floatSharedPreferenceUtility   = new FloatSharedPreferenceUtility(activity, name);
        this.booleanSharedPreferenceUtility = new BooleanSharedPreferenceUtility(activity, name);
        this.integerSharedPreferenceUtility = new IntegerSharedPreferenceUtility(activity, name);
    }

    @Override
    public void set(String key, Object value) {
        if (value.getClass() == String.class) {
            this.stringSharedPreferenceUtility.setValue(key, (String) value);
        } else if (value.getClass() == Float.class) {
            this.floatSharedPreferenceUtility.setValue(key, (Float) value);
        } else if (value.getClass() == Boolean.class) {
            this.booleanSharedPreferenceUtility.setValue(key, (Boolean) value);
        } else if (value.getClass() == Integer.class) {
            this.integerSharedPreferenceUtility.setValue(key, (Integer) value);
        }
    }

    @Override
    public Object get(String key, Object defaultValue) {
        if (defaultValue.getClass() == String.class) {
            return this.stringSharedPreferenceUtility.getValue(key, (String) defaultValue);
        } else if (defaultValue.getClass() == Float.class) {
            return this.floatSharedPreferenceUtility.getValue(key, (Float) defaultValue);
        } else if (defaultValue.getClass() == Boolean.class) {
            return this.booleanSharedPreferenceUtility.getValue(key, (Boolean) defaultValue);
        } else if (defaultValue.getClass() == Integer.class) {
            return this.integerSharedPreferenceUtility.getValue(key, (Integer) defaultValue);
        }
        return null;
    }
}
