package com.consume.api.restapiconsume.model.worldbank;

import lombok.Data;

@Data
public class WorldbankResponseElement {
    private Country indicator;
    private Country country;
    private String countryiso3Code;
    private String date;
    private long value;
    private String unit;
    private String obsStatus;
    private long decimal;
}
