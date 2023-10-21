package com.inshur.weather.domain.forecast.infrastructure;

import com.inshur.weather.domain.forecast.core.model.FiveDayForecast;
import com.inshur.weather.domain.forecast.core.model.FiveDayForecastRequest;
import com.inshur.weather.domain.forecast.core.ports.outgoing.WeatherForecastApi;
import com.inshur.weather.domain.forecast.infrastructure.mapper.OpenWeatherFiveDayForecastToFiveDayForecast;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenWeatherForecastApi implements WeatherForecastApi {

    private final RestTemplate restTemplate;
    private final OpenWeatherFiveDayForecastToFiveDayForecast mapper;

    public OpenWeatherForecastApi(final RestTemplate restTemplate, final OpenWeatherFiveDayForecastToFiveDayForecast mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public FiveDayForecast getFiveDayForecast(final FiveDayForecastRequest request) {

        final HttpHeaders requestHeader = new HttpHeaders();

        requestHeader.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        final HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeader);

        ResponseEntity<String> responseEntity =
                restTemplate.exchange(
                        "",
                        HttpMethod.GET,
                        requestEntity,
                        String.class);

        return mapper.map(responseEntity.getBody());
    }
}
