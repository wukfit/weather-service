package com.inshur.weather.domain.forecast.infrastructure;

import com.inshur.weather.domain.forecast.core.model.*;
import com.inshur.weather.domain.forecast.core.ports.outgoing.WarmestDayEventPublisher;
import com.inshur.weather.domain.forecast.infrastructure.mapper.DayForecastToWarmestDay;
import com.inshur.weather.domain.forecast.infrastructure.mapper.OpenWeatherFiveDayForecastToFiveDayForecast;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class OpenWeatherForecastApiAdapterTest {

    @Test
    void shouldGetWarmestDay() {
        // Given
        final RestTemplate restTemplate = Mockito.mock(RestTemplate.class);
        OpenWeatherDayForecast openWeatherDayForecast = new OpenWeatherDayForecast();
        openWeatherDayForecast.setMaxTemp(100);
        openWeatherDayForecast.setHumidity(50);

        final OpenWeatherFiveDayForecast openWeatherFiveDayForecast = new OpenWeatherFiveDayForecast();
        openWeatherFiveDayForecast.setFiveDayForecast(List.of(openWeatherDayForecast));

        final OpenWeatherFiveDayForecastToFiveDayForecast fiveDayForecastMapper = Mockito.mock(OpenWeatherFiveDayForecastToFiveDayForecast.class);
        final DayForecastToWarmestDay warmestDayMapper = Mockito.mock(DayForecastToWarmestDay.class);
        final WarmestDayEventPublisher warmestDayEventPublisher = Mockito.mock(WarmestDayEventPublisherAdapter.class);
        final OpenWeatherForecastApiAdapter api = new OpenWeatherForecastApiAdapter(restTemplate, fiveDayForecastMapper, warmestDayMapper, warmestDayEventPublisher);
        final Location request = new Location();

        when(restTemplate.exchange(Mockito.anyString(), Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class), Mockito.any(ParameterizedTypeReference.class)))
                .thenReturn(ResponseEntity.of(Optional.of(openWeatherFiveDayForecast)));

        // When
        final WarmestDay forecast = api.getWarmestDay(request);

        // Then
        assertNotNull("Expected method getFiveDayForecast(...) to return a non null FiveDayForecast object", forecast);
    }

}
