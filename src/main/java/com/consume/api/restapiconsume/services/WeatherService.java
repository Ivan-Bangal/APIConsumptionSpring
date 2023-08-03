package com.consume.api.restapiconsume.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.consume.api.restapiconsume.model.weather.Coord;
import com.consume.api.restapiconsume.model.weather.Geocode;
import com.consume.api.restapiconsume.model.weather.Weather;

import reactor.core.publisher.Mono;

/**
 * WeatherService
 */
@Service
@PropertySource("classpath:openweather.properties")
public class WeatherService {

    private final WebClient serviceClient;
    private final String apiKey;
    private final GeocodeService geoService;

    public WeatherService(WebClient.Builder serviceBuilder, @Value("${openweather.api.key}") String apiKey,
            @Value("${openweather.baseurl}") String url, GeocodeService geoService) {
        this.serviceClient = serviceBuilder.baseUrl(url).build();
        this.apiKey = apiKey;
        this.geoService = geoService;
    }

    public Mono<Weather> GetWeatherData(String city) {
        
        Mono<Geocode[]> geocode = geoService.getGeocode(city);
        Coord coordinates = new Coord();

        geocode.subscribe(geo -> setCoordinates(geo,coordinates));
        String serviceURL=String.format("data/2.5/weather?lat=%s&lon=%s&units=metric&appid=%s", coordinates.getLat(),coordinates.getLon(),apiKey);
        Mono<Weather> weatherData = serviceClient.get().uri(serviceURL).retrieve().bodyToMono(Weather.class);
        return weatherData;
    }

    private void setCoordinates(Geocode[] geo,Coord coordinates) {
        Geocode value = geo[0];
        coordinates.setLat(value.getLat());
        coordinates.setLon(value.getLon());
    }
}
