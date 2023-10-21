package com.inshur.weather.domain.forecast.core.ports.outgoing;

import com.inshur.weather.domain.forecast.core.model.FiveDayForecast;
import com.inshur.weather.domain.forecast.core.model.WarmestDayRequest;

public interface WeatherForecastApi {
    FiveDayForecast getFiveDayForecast(WarmestDayRequest request);
}
