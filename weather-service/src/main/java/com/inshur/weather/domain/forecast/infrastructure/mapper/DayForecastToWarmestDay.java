package com.inshur.weather.domain.forecast.infrastructure.mapper;

import com.inshur.weather.domain.forecast.core.model.*;
import org.springframework.stereotype.Component;

@Component
public class DayForecastToWarmestDay {
    public WarmestDay map(DayForecast dayForecast) {
        final WarmestDay warmestDay = new WarmestDay();
        warmestDay.setHumidity(dayForecast.getHumidity());
        warmestDay.setMaxTemp(dayForecast.getMaxTemp());
        warmestDay.setDatetime(dayForecast.getDatetime());
        return warmestDay;
    }
}
