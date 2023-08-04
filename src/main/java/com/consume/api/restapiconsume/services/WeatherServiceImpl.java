package com.consume.api.restapiconsume.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.consume.api.restapiconsume.interfaces.WeatherService;
import com.consume.api.restapiconsume.model.weather.Weather;

import reactor.core.publisher.Mono;

/**
 * WeatherService
 */
@Service
@PropertySource("classpath:openweather.properties")
@Profile("development")
public class WeatherServiceImpl implements WeatherService {

    private final WebClient serviceClient;
    private final String apiKey;

    public WeatherServiceImpl(WebClient.Builder serviceBuilder, @Value("${openweather.api.key}") String apiKey,
            @Value("${openweather.baseurl}") String url) {
        this.serviceClient = serviceBuilder.baseUrl(url).build();
        this.apiKey = apiKey;
    }

    @Override
    public Mono<Weather> getWeatherData(String city) {

        if (city.isEmpty() || city.isBlank() || city.length() == 0)
            throw new IllegalArgumentException("Empty City");

        String serviceURL = String.format("data/2.5/weather?q=%s&appid=%s&units=metric&lang=pt", city, apiKey);

        Mono<Weather> weatherData = serviceClient.get().uri(serviceURL).retrieve().bodyToMono(Weather.class);
        return weatherData;
    }

}
