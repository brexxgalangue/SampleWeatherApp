package com.brex.galangue.sampleweatherapp.api.dto;

public class BeanCoord {

    private float lat;
    private float lon;

    public BeanCoord(int lat, int lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }
}
