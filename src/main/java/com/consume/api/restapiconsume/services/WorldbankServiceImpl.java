package com.consume.api.restapiconsume.services;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.consume.api.restapiconsume.interfaces.WorldbankService;
import reactor.core.publisher.Mono;

@Service
@PropertySource("classpath:worldbankorg.properties")
@Profile("development")
public class WorldbankServiceImpl implements WorldbankService{

    private final WebClient serviceClient;

    public WorldbankServiceImpl(WebClient.Builder serviceBuilder,
            @Value("${worldbankorg.baseurl}") String url) {
        this.serviceClient = serviceBuilder.baseUrl(url).build();
    }

    @Override
    public Mono<Object> getGDPData(String countryCode) {
        if (countryCode.isEmpty() || countryCode.isBlank() || countryCode.length() == 0)
            throw new IllegalArgumentException("Empty Country Code");
        int currentYear = LocalDate.now().getYear();

        int fiveYearsAgo = LocalDate.now().minusYears(5).getYear();

        String serviceURL = String.format("%s/indicator/NY.GDP.MKTP.CD?format=json&date=%s:%s", countryCode, fiveYearsAgo,
                currentYear);

        Mono<Object> gdpData = serviceClient.get().uri(serviceURL).retrieve().bodyToMono(Object.class);

        return gdpData;

    }

    @Override
    public Mono<Object> getPopulationData(String countryCode) {
        if (countryCode.isEmpty() || countryCode.isBlank() || countryCode.length() == 0)
            throw new IllegalArgumentException("Empty Country Code");
    

        int currentYear = LocalDate.now().getYear();
        int fiveYearsAgo = LocalDate.now().minusYears(5).getYear();

        String serviceURL = String.format("%s/indicator/SP.POP.TOTL?format=json&date=%s:%s", countryCode, fiveYearsAgo,
                currentYear);

        return serviceClient.get().uri(serviceURL).retrieve().bodyToMono(Object.class);
    }

}
