package com.inshur.weather.infrastruture;

import com.inshur.weather.domain.forecast.core.model.Location;
import com.inshur.weather.infrastructure.WeatherServiceApplication;
import com.inshur.weather.query.WarmestDayController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(classes = {WeatherServiceApplication.class, WarmestDayController.class})
class WeatherServiceApplicationTests {

	@Autowired
	WarmestDayController warmestDayController;

	@Test
	void contextLoads() {
		assertThat(warmestDayController).isNotNull();
	}

	@Test
	void shouldFailInputValidation() {
		// Given
		final Location location = new Location();
		location.setLatitude(100.0000000001f);
		location.setLongitude(100.0000000001f);

		// When
		Exception exception = assertThrows(HttpClientErrorException.BadRequest.class, () -> {
			warmestDayController.getWarmestDay(location);
		});

		// Then
		Assertions.assertNotNull(exception);
	}

	@Test
	void shouldNotFailInputValidation() {
		// Given
		final Location location = new Location();
		location.setLatitude(50.390202f);
		location.setLongitude(-3.920431f);

		// When/Then
		assertDoesNotThrow(() -> {
			warmestDayController.getWarmestDay(location);
		});

	}
}
