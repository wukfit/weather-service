package com.inshur.weather.query;

import com.inshur.weather.domain.forecast.core.model.DayForecast;
import com.inshur.weather.domain.forecast.core.model.WarmestDayRequest;
import com.inshur.weather.domain.forecast.core.ports.outgoing.WeatherForecastApi;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarmestDayController {

    private final WeatherForecastApi api;

    public WarmestDayController(final WeatherForecastApi api) {
        this.api = api;
    }

    @GetMapping("/warmest-day")
    public @ResponseBody DayForecast getWarmestDay(@Valid final WarmestDayRequest request) {
        return api.getFiveDayForecast(request).getWarmestDay();
    }
}
