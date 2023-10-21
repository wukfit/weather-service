package com.inshur.weather.domain.forecast.infrastructure.mapper;

import com.inshur.weather.domain.forecast.core.model.DayForecast;
import com.inshur.weather.domain.forecast.core.model.FiveDayForecast;
import com.inshur.weather.domain.forecast.core.model.OpenWeatherDayForecast;
import com.inshur.weather.domain.forecast.core.model.OpenWeatherFiveDayForecast;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;

@Component
public class OpenWeatherFiveDayForecastToFiveDayForecast {
    public FiveDayForecast map(OpenWeatherFiveDayForecast openWeatherFiveDayForecast) {

        final List<DayForecast> dayForecastList = openWeatherFiveDayForecast.getFiveDayForecast()
                .stream()
                .map(OpenWeatherFiveDayForecastToFiveDayForecast::openWeatherDayForecastToDayForecast)
                .toList();

        return new FiveDayForecast(dayForecastList, openWeatherFiveDayForecast.getIsoCountryCode());
    }

    private static DayForecast openWeatherDayForecastToDayForecast(OpenWeatherDayForecast openWeatherDayForecast) {
        final DayForecast dayForecast = new DayForecast();
        dayForecast.setHumidity(openWeatherDayForecast.getHumidity());
        dayForecast.setMaxTemp(openWeatherDayForecast.getMaxTemp());
        dayForecast.setDatetime(LocalDateTime.ofInstant(Instant.ofEpochMilli(openWeatherDayForecast.getDatetime()), TimeZone
                .getDefault().toZoneId()));
        return dayForecast;
    }
}
