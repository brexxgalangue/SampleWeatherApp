package com.brex.galangue.sampleweatherapp.api.dto;

import java.util.ArrayList;

public class BeanForecast {
    private String cod;
    private int message;
    private int cnt;
    private ArrayList<BeanList> list;
    private BeanCity city;

    public BeanForecast(String cod, int message, int cnt, ArrayList<BeanList> list, BeanCity city) {
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
        this.city = city;
    }


    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public ArrayList<BeanList> getList() {
        return list;
    }

    public void setList(ArrayList<BeanList> list) {
        this.list = list;
    }

    public BeanCity getCity() {
        return city;
    }

    public void setCity(BeanCity city) {
        this.city = city;
    }
}
