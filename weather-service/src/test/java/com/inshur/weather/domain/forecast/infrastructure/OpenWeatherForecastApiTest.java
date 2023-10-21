package com.inshur.weather.domain.forecast.infrastructure;

import com.inshur.weather.domain.forecast.core.model.Location;
import com.inshur.weather.domain.forecast.core.model.WarmestDay;
import com.inshur.weather.domain.forecast.infrastructure.mapper.OpenWeatherFiveDayForecastToFiveDayForecast;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@ContextConfiguration(classes = OpenWeatherForecastApi.class)
@RunWith(SpringRunner.class)
class OpenWeatherForecastApiTest {

    @MockBean
    private RestTemplate restTemplate;
    @MockBean
    private OpenWeatherFiveDayForecastToFiveDayForecast mapper;

    @Autowired
    private OpenWeatherForecastApi api;

    // FIXME Test failing... need to remember how Spring etc works in order to wire in the dependencies
    @Test
    void shouldGetWarmestDay() {
        // Given
        final Location request = new Location();

        // When
        final WarmestDay forecast = api.getWarmestDay(request);

        // Then
        assertNotNull("Expected method getFiveDayForecast(...) to return a non null FiveDayForecast object", forecast);
    }

}
