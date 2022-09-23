package com.brex.galangue.sampleweatherapp.api.dto;

import java.util.ArrayList;

public class BeanList {

    private int dt;
    private BeanMain main;
    private ArrayList<BeanWeather> weather;
    private BeanClouds clouds;
    private BeanWind wind;
    private int visibility;
    private float pop;
    private BeanRain rain;
    private BeanSys sys;
    private String dt_txt;

    public BeanList(int dt, BeanMain main, ArrayList<BeanWeather> weather, BeanClouds clouds, BeanWind wind, int visibility, float pop, BeanRain rain, BeanSys sys, String dt_txt) {
        this.dt = dt;
        this.main = main;
        this.weather = weather;
        this.clouds = clouds;
        this.wind = wind;
        this.visibility = visibility;
        this.pop = pop;
        this.rain = rain;
        this.sys = sys;
        this.dt_txt = dt_txt;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public BeanMain getMain() {
        return main;
    }

    public void setMain(BeanMain main) {
        this.main = main;
    }

    public ArrayList<BeanWeather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<BeanWeather> weather) {
        this.weather = weather;
    }

    public BeanClouds getClouds() {
        return clouds;
    }

    public void setClouds(BeanClouds clouds) {
        this.clouds = clouds;
    }

    public BeanWind getWind() {
        return wind;
    }

    public void setWind(BeanWind wind) {
        this.wind = wind;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public float getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public BeanRain getRain() {
        return rain;
    }

    public void setRain(BeanRain rain) {
        this.rain = rain;
    }

    public BeanSys getSys() {
        return sys;
    }

    public void setSys(BeanSys sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
