package com.inshur.weather.domain.forecast.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class OpenWeatherForecastApiConfig {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
