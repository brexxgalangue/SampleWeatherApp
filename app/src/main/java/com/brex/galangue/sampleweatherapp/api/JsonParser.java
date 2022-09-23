package com.brex.galangue.sampleweatherapp.api;

import com.brex.galangue.sampleweatherapp.api.dto.BeanForecast;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class JsonParser {
    public static BeanForecast getForecastData(String item) {
        Gson gson = new Gson();
        Type listType = new TypeToken<BeanForecast>(){}.getType();
        BeanForecast forecast = gson.fromJson(item, listType);
        return forecast;
    }
}
