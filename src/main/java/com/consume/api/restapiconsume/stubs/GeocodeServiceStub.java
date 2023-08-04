package com.consume.api.restapiconsume.stubs;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.consume.api.restapiconsume.interfaces.GeocodeService;
import com.consume.api.restapiconsume.model.weather.Geocode;
import reactor.core.publisher.Mono;

@Component
@Profile("Test")
public class GeocodeServiceStub implements GeocodeService {

    @Override
    public Mono<Geocode[]> getGeocode(String city) {
        Geocode mockGeocode = new Geocode();
        mockGeocode.setName(city);
        mockGeocode.setLat(12.345);
        mockGeocode.setLon(67.890);
        mockGeocode.setCountry("Mock Country");
        mockGeocode.setState("Mock State"); 
        return Mono.just(new Geocode[] { mockGeocode });
    }
}

