package com.consume.api.restapiconsume.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.consume.api.restapiconsume.model.exchangerate.RateExchange;

import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:exchangerate.properties")
public class ExchangeRateService {

    private final WebClient serviceClient;
    private final String apiKey;

    public ExchangeRateService(WebClient.Builder serviceBuilder, @Value("${exchangerate.api.key}") String apiKey,
            @Value("${exchangerate.baseurl}") String url) {
        this.serviceClient = serviceBuilder.baseUrl(url).build();
        this.apiKey = apiKey;
    }


    public Mono<RateExchange> getRateExchangeForCoin(String coin){
        String serviceUrl= String.format("%s/latest/%s",apiKey, coin);

        Mono<RateExchange> exchangeRateMono = serviceClient.get().uri(serviceUrl).retrieve().bodyToMono(RateExchange.class);

        return exchangeRateMono;
    }

}
