package com.inshur.weather.domain.forecast.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class OpenWeatherFiveDayForecast {

    @JsonProperty("dt")
    private int datetime;

    private String isoCountryCode;

    @JsonProperty("list")
    private List<OpenWeatherDayForecast> fiveDayForecast;

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public List<OpenWeatherDayForecast> getFiveDayForecast() {
        return new ArrayList<>(Objects.requireNonNullElse(fiveDayForecast, Collections.emptyList()));
    }

    public void setFiveDayForecast(final List<OpenWeatherDayForecast> fiveDayForecast) {
        this.fiveDayForecast = fiveDayForecast;
    }

    @JsonProperty("city")
    private void parseCityJsonObject(Map<String, Object> city) {
        isoCountryCode = city.get("country").toString();
    }

    public String getIsoCountryCode() {
        return isoCountryCode;
    }
}
