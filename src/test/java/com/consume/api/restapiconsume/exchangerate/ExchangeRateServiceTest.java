package com.consume.api.restapiconsume.exchangerate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;
import com.consume.api.restapiconsume.interfaces.ExchangeRateService;
import com.consume.api.restapiconsume.model.exchangerate.RateExchange;
import com.consume.api.restapiconsume.model.weather.Weather;

import reactor.core.publisher.Mono;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
@ActiveProfiles("Test")
public class ExchangeRateServiceTest {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Test
    public void testSucessfullCall() {
        Mono<RateExchange> rateExchangeForCoin = exchangeRateService.getRateExchangeForCoin("MZN");
        RateExchange exchangeRate = rateExchangeForCoin.block();
        assertThat(exchangeRate).isNotNull();
    }

    @Test
    public void testEmptyCoin(){
        assertThatThrownBy(() -> exchangeRateService.getRateExchangeForCoin(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Empty Coin Input");
    }
}
