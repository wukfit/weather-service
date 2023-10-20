package com.inshur.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WeatherServiceApplicationTests {

	@Autowired
	ForecastController forecastController;

	@Test
	void contextLoads() {
		assertThat(forecastController).isNotNull();
	}

}
