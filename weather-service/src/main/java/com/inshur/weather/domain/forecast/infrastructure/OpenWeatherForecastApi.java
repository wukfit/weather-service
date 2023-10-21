package com.inshur.weather.domain.forecast.infrastructure;

import com.inshur.weather.domain.forecast.core.model.FiveDayForecast;
import com.inshur.weather.domain.forecast.core.model.FiveDayForecastRequest;
import com.inshur.weather.domain.forecast.core.ports.outgoing.WeatherForecastApi;

public class OpenWeatherForecastApi implements WeatherForecastApi {
    @Override
    public FiveDayForecast getFiveDayForecast(final FiveDayForecastRequest request) {
        return null;
    }
}
