package com.consume.api.restapiconsume.interfaces;

import com.consume.api.restapiconsume.model.exchangerate.RateExchange;

import reactor.core.publisher.Mono;

public interface ExchangeRateService {
    Mono<RateExchange> getRateExchangeForCoin(String coin);
}
