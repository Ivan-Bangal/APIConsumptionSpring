package com.consume.api.restapiconsume.interfaces;

import reactor.core.publisher.Mono;

public interface WorldbankService {
    Mono<Object> getGDPData(String countryCode);
    Mono<Object> getPopulationData(String countryCode);
}
