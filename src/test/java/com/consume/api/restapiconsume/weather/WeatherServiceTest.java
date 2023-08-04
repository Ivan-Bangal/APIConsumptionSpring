package com.consume.api.restapiconsume.weather;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.consume.api.restapiconsume.interfaces.WeatherService;
import com.consume.api.restapiconsume.model.weather.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Mono;

@SpringBootTest
@ActiveProfiles("Test")
public class WeatherServiceTest {
    
    @Autowired
    WeatherService service;

    @Test
    public void callService(){
        Mono<Weather> weatherData = service.getWeatherData("Maputo");
        Weather weather = weatherData.block();
        assertThat(weather).isNotNull();
    }

    @Test
    public void testErrorHandlingForEmptyCity() {
        assertThatThrownBy(() -> service.getWeatherData(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Empty City");
    }

}
