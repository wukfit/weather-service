package com.inshur.weather.query;

import com.inshur.weather.domain.forecast.core.model.Location;
import com.inshur.weather.domain.forecast.core.model.WarmestDay;
import com.inshur.weather.domain.forecast.core.ports.outgoing.WeatherForecastApi;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarmestDayController {

    private final WeatherForecastApi api;

    public WarmestDayController(final WeatherForecastApi api) {
        this.api = api;
    }

    @ExceptionHandler({ IllegalStateException.class })
    public ResponseEntity<String> handleException(final Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @GetMapping("/warmest-day")
    public @ResponseBody WarmestDay getWarmestDay(@Valid final Location location) {
        return api.getWarmestDay(location);
    }
}
