package com.consume.api.restapiconsume.interfaces;

import com.consume.api.restapiconsume.model.weather.Geocode;

import reactor.core.publisher.Mono;

public interface GeocodeService {
    Mono<Geocode[]> getGeocode(String city);
}
