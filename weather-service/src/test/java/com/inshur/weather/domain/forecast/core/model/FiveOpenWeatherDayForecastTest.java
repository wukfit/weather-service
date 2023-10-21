package com.inshur.weather.domain.forecast.core.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class FiveOpenWeatherDayForecastTest {

    @Test
    public void shouldGetWarmestDayWithLowestHumidityAndValidLocation() {
        // Given
        final DayForecast dayForecast1 = new DayForecast();
        dayForecast1.setMaxTemp(100.00f);
        dayForecast1.setHumidity(69);

        final DayForecast dayForecast2 = new DayForecast();
        dayForecast2.setMaxTemp(100.00f);
        dayForecast2.setHumidity(30);

        final FiveDayForecast fiveDayForecast = new FiveDayForecast(Arrays.asList(dayForecast1, dayForecast2), "GB");

        // When
        final DayForecast warmestDay = fiveDayForecast.getWarmestDay();

        // Then
        assertEquals(dayForecast2, warmestDay);
    }

    @Test
    public void shouldGetFirstWarmestDayWithIdenticalHumidityAndValidLocation() {
        // Given
        final DayForecast dayForecast1 = new DayForecast();
        dayForecast1.setMaxTemp(100.00f);
        dayForecast1.setHumidity(30);

        final DayForecast dayForecast2 = new DayForecast();
        dayForecast2.setMaxTemp(100.00f);
        dayForecast2.setHumidity(30);

        final FiveDayForecast fiveDayForecast = new FiveDayForecast(Arrays.asList(dayForecast1, dayForecast2), "GB");

        // When
        final DayForecast warmestDay = fiveDayForecast.getWarmestDay();

        // Then
        assertEquals(dayForecast1, warmestDay);
    }


    @Test
    public void shouldNotGetWarmestDayWithInvalidLocation() {
        // Given
        final DayForecast dayForecast1 = new DayForecast();
        dayForecast1.setMaxTemp(100.00f);
        dayForecast1.setHumidity(30);

        final DayForecast dayForecast2 = new DayForecast();
        dayForecast2.setMaxTemp(100.00f);
        dayForecast2.setHumidity(30);

        final FiveDayForecast fiveDayForecast = new FiveDayForecast(Arrays.asList(dayForecast1, dayForecast2), "CA");

        // When
        Exception exception = assertThrows(IllegalStateException.class, fiveDayForecast::getWarmestDay);

        // Then
        assertNotNull(exception);
    }
}
