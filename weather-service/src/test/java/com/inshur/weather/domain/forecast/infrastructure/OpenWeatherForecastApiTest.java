package com.inshur.weather.domain.forecast.infrastructure;

import com.inshur.weather.domain.forecast.core.model.FiveDayForecast;
import com.inshur.weather.domain.forecast.core.model.FiveDayForecastRequest;
import com.inshur.weather.domain.forecast.infrastructure.mapper.OpenWeatherFiveDayForecastToFiveDayForecast;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
class OpenWeatherForecastApiTest {

    @Mock
    private RestTemplate restTemplate;
    @Mock
    private OpenWeatherFiveDayForecastToFiveDayForecast mapper;

    @InjectMocks
    private OpenWeatherForecastApi api;

    @Test
    void shouldGetFiveDayForecast() {
        // Given
        final FiveDayForecastRequest request = new FiveDayForecastRequest();

        // When
        final FiveDayForecast forecast = api.getFiveDayForecast(request);

        // Then
        assertNotNull(forecast, "Expected method getFiveDayForecast(...) to return a non null FiveDayForecast object");
    }


}
