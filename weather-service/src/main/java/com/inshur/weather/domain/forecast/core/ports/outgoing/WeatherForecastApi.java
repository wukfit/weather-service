package com.inshur.weather.domain.forecast.core.ports.outgoing;

import com.inshur.weather.domain.forecast.core.model.Location;
import com.inshur.weather.domain.forecast.core.model.WarmestDay;

public interface WeatherForecastApi {
    WarmestDay getWarmestDay(Location location);
}
