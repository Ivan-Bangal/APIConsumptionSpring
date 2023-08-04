package com.consume.api.restapiconsume.interfaces;

import com.consume.api.restapiconsume.model.weather.Weather;

import reactor.core.publisher.Mono;

public interface WeatherService {
    Mono<Weather> getWeatherData(String city);
}
