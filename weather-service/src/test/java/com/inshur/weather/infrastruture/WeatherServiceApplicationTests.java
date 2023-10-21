package com.inshur.weather.infrastruture;

import com.inshur.weather.domain.forecast.core.model.FiveDayForecastRequest;
import com.inshur.weather.infrastructure.WeatherServiceApplication;
import com.inshur.weather.query.WarmestDayController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.HttpClientErrorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(classes = {WeatherServiceApplication.class, WarmestDayController.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WeatherServiceApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	WarmestDayController warmestDayController;

	@Test
	void contextLoads() {
		assertThat(warmestDayController).isNotNull();
	}

	@Test
	void shouldFailInputValidation() {
		// Given
		final FiveDayForecastRequest fiveDayForecastRequest = new FiveDayForecastRequest();
		fiveDayForecastRequest.setLatitude(100.0000000001f);
		fiveDayForecastRequest.setLongitude(100.0000000001f);

		// When
		Exception exception = assertThrows(HttpClientErrorException.BadRequest.class, () -> {
			warmestDayController.warmestDay(fiveDayForecastRequest);
		});

		// Then
		Assertions.assertNotNull(exception);
	}

	@Test
	void shouldNotFailInputValidation() {
		// Given
		final FiveDayForecastRequest fiveDayForecastRequest = new FiveDayForecastRequest();
		fiveDayForecastRequest.setLatitude(50.390202f);
		fiveDayForecastRequest.setLongitude(-3.920431f);

		// When/Then
		assertDoesNotThrow(() -> {
			warmestDayController.warmestDay(fiveDayForecastRequest);
		});

	}
}
