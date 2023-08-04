package com.consume.api.restapiconsume.stubs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.consume.api.restapiconsume.interfaces.WorldbankService;
import reactor.core.publisher.Mono;

@Component
@Profile("Test")
public class WorldbankServiceStub implements WorldbankService {

    @Override
    public Mono<Object> getGDPData(String countryCode) {
    
        return Mono.just(createMockGDPData());
    }

    @Override
    public Mono<Object> getPopulationData(String countryCode) {
        return Mono.just(createMockPopulationData());
    }

    private Map<String, Object> createMockGDPData() {
        
        Map<String, Object> mockData = new HashMap<>();
        mockData.put("indicator", "NY.GDP.MKTP.CD");
        mockData.put("country", "Mock Country");
        mockData.put("value", 1234567890);
        
        
        return mockData;
    }

    private Map<String, Object> createMockPopulationData() {
        
        Map<String, Object> mockData = new HashMap<>();
        mockData.put("indicator", "SP.POP.TOTL");
        mockData.put("country", "Mock Country");
        mockData.put("value", 987654321);
        
        
        return mockData;
    }
}
