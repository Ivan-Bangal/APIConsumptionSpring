package com.consume.api.restapiconsume.services;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.consume.api.restapiconsume.model.worldbank.WorldbankResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:worldbankorg.properties")
public class WorldbankService {

    private final WebClient serviceClient;

    public WorldbankService(WebClient.Builder serviceBuilder,
            @Value("${worldbankorg.baseurl}") String url) {
        this.serviceClient = serviceBuilder.baseUrl(url).build();
    }

    public Mono<Object> getGDPData(String cityCode) {
        int currentYear = LocalDate.now().getYear();

        int fiveYearsAgo = LocalDate.now().minusYears(5).getYear();

        String serviceURL = String.format("%s/indicator/NY.GDP.MKTP.CD?format=json&date=%s:%s", cityCode, fiveYearsAgo,
                currentYear);

        Mono<Object> gdpData = serviceClient.get().uri(serviceURL).retrieve().bodyToMono(Object.class);

        return gdpData;

    }

    public Mono<Object> getPopulationData(String cityCode) {
        int currentYear = LocalDate.now().getYear();
        int fiveYearsAgo = LocalDate.now().minusYears(5).getYear();

        String serviceURL = String.format("%s/indicator/SP.POP.TOTL?format=json&date=%s:%s", cityCode, fiveYearsAgo,
                currentYear);

        return serviceClient.get().uri(serviceURL).retrieve().bodyToMono(Object.class);
    }

}
