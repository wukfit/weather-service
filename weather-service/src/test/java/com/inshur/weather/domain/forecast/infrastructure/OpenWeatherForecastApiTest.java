package com.inshur.weather.domain.forecast.infrastructure;

import com.inshur.weather.domain.forecast.core.model.FiveDayForecast;
import com.inshur.weather.domain.forecast.core.model.FiveDayForecastRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class OpenWeatherForecastApiTest {

    @Test
    void shouldGetFiveDayForecast() {
        // Given
        final FiveDayForecastRequest request = new FiveDayForecastRequest();
        final OpenWeatherForecastApi api = new OpenWeatherForecastApi();

        // When
        final FiveDayForecast forecast = api.getFiveDayForecast(request);

        // Then
        assertNotNull(forecast, "Expected method getFiveDayForecast(...) to return a non null FiveDayForecast object");
    }


}
