package com.inshur.weather.domain.forecast.core.model;

import jakarta.validation.constraints.Digits;
import org.springframework.stereotype.Component;

@Component
public class WarmestDayRequest {
    @Digits(integer = 3, fraction = 6)
    private float latitude;

    @Digits(integer = 3, fraction = 6)
    private float longitude;

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
