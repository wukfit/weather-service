package com.inshur.weather.domain.forecast.core.model;

import java.util.Date;
import java.util.Objects;

public class WarmestDay {

    private Date datetime;
    private float maxTemp;
    private int humidity;

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
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
        WarmestDay that = (WarmestDay) o;
        return datetime == that.datetime && Float.compare(that.maxTemp, maxTemp) == 0 && humidity == that.humidity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(datetime, maxTemp, humidity);
    }
}
