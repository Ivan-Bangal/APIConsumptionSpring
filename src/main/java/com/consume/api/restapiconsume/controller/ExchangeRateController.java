package com.consume.api.restapiconsume.controller;
import org.springframework.web.bind.annotation.RestController;

import com.consume.api.restapiconsume.interfaces.ExchangeRateService;
import com.consume.api.restapiconsume.model.exchangerate.RateExchange;

import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/exchangeRate")
public class ExchangeRateController {
    
    private final ExchangeRateService exchangeRateService;

    public ExchangeRateController(ExchangeRateService exchangeRateService){
        this.exchangeRateService = exchangeRateService;
    }
   
    @GetMapping("/{coin}")
    public Mono<RateExchange> getRateExchange(@PathVariable String coin) {
        return exchangeRateService.getRateExchangeForCoin(coin);
    }
    

}
