package com.inshur.weather.domain.forecast.core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;

public class OpenWeatherDayForecast {

    @JsonProperty("dt")
    private int datetime;
    private float maxTemp;
    private int humidity;

    @JsonProperty("main")
    private void parseMainJsonObject(Map<String, String> main) {
        maxTemp = Float.parseFloat(main.get("temp_max"));
        humidity = Integer.parseInt(main.get("humidity"), 10);
    }

    public int getDatetime() {
        return datetime;
    }

    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OpenWeatherDayForecast that = (OpenWeatherDayForecast) o;
        return datetime == that.datetime && Float.compare(that.maxTemp, maxTemp) == 0 && humidity == that.humidity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(datetime, maxTemp, humidity);
    }
}
