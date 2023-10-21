package com.inshur.weather.domain.forecast.core.model;

import java.util.*;

public record FiveDayForecast(List<DayForecast> dayForecastList, String isoCountryCode) {

    private static final String ALLOWED_COUNTRY = "GB";

    public DayForecast getWarmestDay() {
        if (!ALLOWED_COUNTRY.equalsIgnoreCase(isoCountryCode)) {
            throw new IllegalStateException(String.format("isoCountryCode [%s] is not a valid location", isoCountryCode));
        }

        final DayForecast maxTemp = dayForecastList.stream().max(Comparator.comparing(DayForecast::getMaxTemp)).orElse(null);

        final List<DayForecast> duplicateMaxTemps = dayForecastList.stream().filter(dayForecast -> dayForecast.getMaxTemp() == maxTemp.getMaxTemp()).toList();

        return duplicateMaxTemps.stream().min(Comparator.comparing(DayForecast::getHumidity)).orElse(null);
    }

}
