package com.consume.api.restapiconsume.worldbank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.consume.api.restapiconsume.interfaces.WeatherService;
import com.consume.api.restapiconsume.interfaces.WorldbankService;
import com.consume.api.restapiconsume.model.weather.Weather;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import reactor.core.publisher.Mono;

@SpringBootTest
@ActiveProfiles("Test")
public class WorldBankServiceTest {
    

    @Autowired
    WorldbankService service;

    @Test
    public void testGetGDPData(){
        Mono<Object> gdpData = service.getGDPData("MZ");
        Object gdp = gdpData.block();
        assertThat(gdp).isNotNull();
    }

    @Test
    public void testGetPopulationData(){
        Mono<Object> populationData = service.getPopulationData("MZ");
        Object population = populationData.block();
        assertThat(population).isNotNull();
    }

    @Test
    public void testErrorHandlingGDPForEmptyCountry() {
        assertThatThrownBy(() -> service.getGDPData(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Empty Country Code");
        
    }

    @Test
    public void testErrorHandlingPopulationForEmptyCountry() {
        assertThatThrownBy(() -> service.getPopulationData(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Empty Country Code");
        
    }


}
