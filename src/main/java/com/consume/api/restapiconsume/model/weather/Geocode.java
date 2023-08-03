package com.consume.api.restapiconsume.model.weather;
import java.util.Map;
import lombok.Data;

@Data

public class Geocode {
    private String name;
    private Map<String, String> localNames;
    private double lat;
    private double lon;
    private String country;
    private String state;

}
