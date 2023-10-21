package com.inshur.weather.infrastruture;

import com.inshur.weather.infrastructure.WeatherServiceApplication;
import com.inshur.weather.query.WarmestDayController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {WeatherServiceApplication.class, WarmestDayController.class})
class WeatherServiceApplicationTests {

	@Autowired
	WarmestDayController warmestDayController;

	@Test
	void contextLoads() {
		assertThat(warmestDayController).isNotNull();
	}

}
