package com.consume.api.restapiconsume.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.consume.api.restapiconsume.interfaces.GeocodeService;
import com.consume.api.restapiconsume.model.weather.Geocode;

import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:openweather.properties")
@Profile("development")
public class GeocodeServiceImpl implements GeocodeService {

    private final WebClient serviceClient;
    private final String apiKey;

    public GeocodeServiceImpl(WebClient.Builder serviceBuilder, @Value("${openweather.api.key}") String apiKey,
            @Value("${openweather.baseurl}") String url) {
        this.serviceClient = serviceBuilder.baseUrl(url).build();
        this.apiKey = apiKey;
    }

    @Override
    public Mono<Geocode[]> getGeocode(String city) {

        if (city.isEmpty() || city.isBlank() || city.length() == 0)
            throw new IllegalArgumentException("Empty City Input");
        
        String serviceURL=String.format("geo/1.0/direct?q=%s&appid=%s", city,apiKey);

        Mono<Geocode[]> geoMono = serviceClient.get().uri(serviceURL).retrieve().bodyToMono(Geocode[].class);

        return geoMono;

    }

}
