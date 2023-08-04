package com.consume.api.restapiconsume.stubs;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.consume.api.restapiconsume.interfaces.WeatherService;
import com.consume.api.restapiconsume.model.weather.Coord;
import com.consume.api.restapiconsume.model.weather.Weather;
import com.consume.api.restapiconsume.model.weather.WeatherElement;
import com.consume.api.restapiconsume.model.weather.Main;
import com.consume.api.restapiconsume.model.weather.Wind;
import com.consume.api.restapiconsume.model.weather.Clouds;
import com.consume.api.restapiconsume.model.weather.Sys;
import reactor.core.publisher.Mono;

@Component
@Profile("Test")
public class WeatherServiceStub implements WeatherService {

    @Override
    public Mono<Weather> getWeatherData(String city) {
        // Create and return a mock Weather object here
        Weather mockWeather = new Weather();
        
        // Create and set mock data for the various fields in the Weather object
        Coord coord = new Coord();
        coord.setLat(12.345);
        coord.setLon(67.890);
        mockWeather.setCoord(coord);
        
        WeatherElement[] weatherElements = new WeatherElement[1];
        WeatherElement weatherElement = new WeatherElement();
        weatherElement.setId(800);
        weatherElement.setMain("Clear");
        weatherElement.setDescription("Clear sky");
        weatherElement.setIcon("01d");
        weatherElements[0] = weatherElement;
        mockWeather.setWeather(weatherElements);
        
        mockWeather.setBase("stations");
        
        Main main = new Main();
        main.setTemp(25.0);
        main.setFeelsLike(28.0);
        main.setPressure(1012);
        main.setHumidity(60);
        mockWeather.setMain(main);
        
        mockWeather.setVisibility(10000);
        
        Wind wind = new Wind();
        wind.setSpeed(5.0);
        wind.setDeg(180);
        mockWeather.setWind(wind);
        
        Clouds clouds = new Clouds();
        clouds.setAll(0);
        mockWeather.setClouds(clouds);
        
        mockWeather.setDt(1678901234);
        
        Sys sys = new Sys();
        sys.setType(1);
        sys.setId(1234);
        sys.setCountry("US");
        sys.setSunrise(1678901234);
        sys.setSunset(1678945678);
        mockWeather.setSys(sys);
        
        mockWeather.setTimezone(-25200);
        
        mockWeather.setId(1234567);
        mockWeather.setName("MockCity");
        
        mockWeather.setCod(200);
        
        return Mono.just(mockWeather);
    }
}
