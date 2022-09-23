package com.brex.galangue.sampleweatherapp.api.dto;

public class BeanCity {
    private int id;
    private String name;
    private BeanCoord coord;
    private String country;
    private int population;
    private int timezone;
    private int sunrise;
    private int sunset;

    public BeanCity(int id, String name, BeanCoord coord, String country, int population, int timezone, int sunrise, int sunset) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
        this.timezone = timezone;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}
