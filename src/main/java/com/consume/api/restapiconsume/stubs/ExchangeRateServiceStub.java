package com.consume.api.restapiconsume.stubs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.consume.api.restapiconsume.interfaces.ExchangeRateService;
import com.consume.api.restapiconsume.model.exchangerate.RateExchange;
import reactor.core.publisher.Mono;

@Component
@Profile("Test")
public class ExchangeRateServiceStub implements ExchangeRateService {

    @Override
    public Mono<RateExchange> getRateExchangeForCoin(String coin) {
        
        RateExchange mockRateExchange = new RateExchange();
        mockRateExchange.setResult("success");
        mockRateExchange.setBase_code(coin);
        mockRateExchange.setTime_last_update_unix(1630210800);
        mockRateExchange.setTime_next_update_unix(1630297200);
        Map<String, Double> conversionRates = new HashMap<>();
        conversionRates.put("EUR", 0.85);
        conversionRates.put("GBP", 0.72);
        mockRateExchange.setConversion_rates(conversionRates);
        return Mono.just(mockRateExchange);
    }
}

