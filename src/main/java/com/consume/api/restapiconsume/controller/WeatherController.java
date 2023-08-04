package com.consume.api.restapiconsume.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consume.api.restapiconsume.interfaces.WeatherService;
import com.consume.api.restapiconsume.model.weather.Weather;
import com.consume.api.restapiconsume.services.WeatherServiceImpl;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/weather")
public class WeatherController {
    
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService= weatherService;
    }

    @GetMapping("/{city}")
    public Mono<Weather> getMethodName(@PathVariable String city) {
        return weatherService.getWeatherData(city);
    }
    


}
