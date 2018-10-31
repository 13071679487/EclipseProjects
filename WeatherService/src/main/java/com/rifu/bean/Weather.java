package com.rifu.bean;

import java.util.Date;

public class Weather {
    private Integer weatherCityid;

    private String weatherCityname;

    private String weatherCitypy;

    private Date weatherDate;

    private String weatherType;

    private String weatherDesc;

    private Short weatherHightemp;

    private Short weatherLowtemp;

    public Integer getWeatherCityid() {
        return weatherCityid;
    }

    public void setWeatherCityid(Integer weatherCityid) {
        this.weatherCityid = weatherCityid;
    }

    public String getWeatherCityname() {
        return weatherCityname;
    }

    public void setWeatherCityname(String weatherCityname) {
        this.weatherCityname = weatherCityname == null ? null : weatherCityname.trim();
    }

    public String getWeatherCitypy() {
        return weatherCitypy;
    }

    public void setWeatherCitypy(String weatherCitypy) {
        this.weatherCitypy = weatherCitypy == null ? null : weatherCitypy.trim();
    }

    public Date getWeatherDate() {
        return weatherDate;
    }

    public void setWeatherDate(Date weatherDate) {
        this.weatherDate = weatherDate;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType == null ? null : weatherType.trim();
    }

    public String getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(String weatherDesc) {
        this.weatherDesc = weatherDesc == null ? null : weatherDesc.trim();
    }

    public Short getWeatherHightemp() {
        return weatherHightemp;
    }

    public void setWeatherHightemp(Short weatherHightemp) {
        this.weatherHightemp = weatherHightemp;
    }

    public Short getWeatherLowtemp() {
        return weatherLowtemp;
    }

    public void setWeatherLowtemp(Short weatherLowtemp) {
        this.weatherLowtemp = weatherLowtemp;
    }
}