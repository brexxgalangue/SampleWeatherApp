package com.brex.galangue.sampleweatherapp.api.dto;

public class BeanWind {
    private float speed;
    private float deg;
    private float gust;

    public BeanWind(float speed, float deg, float gust) {
        this.speed = speed;
        this.deg = deg;
        this.gust = gust;
    }


    public float getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public float getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public float getGust() {
        return gust;
    }

    public void setGust(int gust) {
        this.gust = gust;
    }
}
