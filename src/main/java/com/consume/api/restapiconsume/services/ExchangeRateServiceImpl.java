package com.consume.api.restapiconsume.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.consume.api.restapiconsume.interfaces.ExchangeRateService;
import com.consume.api.restapiconsume.model.exchangerate.RateExchange;

import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:exchangerate.properties")
@Profile("development")
public class ExchangeRateServiceImpl implements ExchangeRateService {

    private final WebClient serviceClient;
    private final String apiKey;

    public ExchangeRateServiceImpl(WebClient.Builder serviceBuilder, @Value("${exchangerate.api.key}") String apiKey,
            @Value("${exchangerate.baseurl}") String url) {
        this.serviceClient = serviceBuilder.baseUrl(url).build();
        this.apiKey = apiKey;
    }

    @Override
    public Mono<RateExchange> getRateExchangeForCoin(String coin){
        if (coin.isEmpty() || coin.isBlank() || coin.length() == 0)
            throw new IllegalArgumentException("Empty Coin Input");

        String serviceUrl= String.format("%s/latest/%s",apiKey, coin);

        Mono<RateExchange> exchangeRateMono = serviceClient.get().uri(serviceUrl).retrieve().bodyToMono(RateExchange.class);

        return exchangeRateMono;
    }

}
