package com.inshur.weather.domain.forecast.core.ports.outgoing;

import com.inshur.weather.domain.forecast.core.model.FiveDayForecast;
import com.inshur.weather.domain.forecast.core.model.FiveDayForecastRequest;

public interface WeatherForecastApi {
    FiveDayForecast getFiveDayForecast(FiveDayForecastRequest request);
}
