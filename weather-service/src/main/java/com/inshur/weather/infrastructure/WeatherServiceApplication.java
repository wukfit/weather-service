package com.inshur.weather.infrastructure;

import com.inshur.weather.domain.forecast.infrastructure.OpenWeatherForecastApiConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"com.inshur.weather"})
@Import({
		OpenWeatherForecastApiConfig.class
})
public class WeatherServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

}
