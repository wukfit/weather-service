package com.inshur.weather.domain.forecast.infrastructure;

import com.inshur.weather.domain.forecast.core.model.FiveDayForecast;
import com.inshur.weather.domain.forecast.core.model.WarmestDayRequest;
import com.inshur.weather.domain.forecast.core.model.OpenWeatherFiveDayForecast;
import com.inshur.weather.domain.forecast.core.ports.outgoing.WeatherForecastApi;
import com.inshur.weather.domain.forecast.infrastructure.mapper.OpenWeatherFiveDayForecastToFiveDayForecast;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class OpenWeatherForecastApi implements WeatherForecastApi {

    // TODO [JIRA_123] Store this externally e.g. Vault or similar
    private static final String API_KEY = "3fd0996505c76bcc9ad26fee55ed13c5";
    public static final String OPEN_WEATHER_API_FORECAST_URL = "https://api.openweathermap.org/data/2.5/forecast?lat=%s&lon=%s&appid=%s";

    private final RestTemplate restTemplate;
    private final OpenWeatherFiveDayForecastToFiveDayForecast mapper;

    public OpenWeatherForecastApi(final RestTemplate restTemplate, final OpenWeatherFiveDayForecastToFiveDayForecast mapper) {
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    @Override
    public FiveDayForecast getFiveDayForecast(final WarmestDayRequest request) {
        // TODO [JIRA] fire domain event WarmestDayRequestedEvent
        final HttpHeaders requestHeader = new HttpHeaders();

        requestHeader.add("Accept", MediaType.APPLICATION_JSON_VALUE);
        final HttpEntity<Object> requestEntity = new HttpEntity<>(requestHeader);

        final String url = String.format(OPEN_WEATHER_API_FORECAST_URL, request.getLatitude(), request.getLongitude(), API_KEY);
        final ResponseEntity<OpenWeatherFiveDayForecast> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<>() {
        });

        // TODO [JIRA] fire domain event ForecastDataReceivedEvent

        final FiveDayForecast fiveDayForecast = mapper.map(Objects.requireNonNull(responseEntity.getBody()));

        // TODO [JIRA] fire domain event WarmestDayFoundEvent

        return fiveDayForecast;
    }
}
