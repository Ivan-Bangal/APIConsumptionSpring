package com.consume.api.restapiconsume.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consume.api.restapiconsume.interfaces.GeocodeService;
import com.consume.api.restapiconsume.model.weather.Geocode;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/GeoCode")
public class GeocodeController {
    
    private final GeocodeService geocodeService;

    public GeocodeController(GeocodeService geocodeService) {
        this.geocodeService = geocodeService;
    }

    @GetMapping("/{city}")
    public Mono<Geocode[]> GetGeoData(@PathVariable String city){
        return geocodeService.getGeocode(city);
    }


}
