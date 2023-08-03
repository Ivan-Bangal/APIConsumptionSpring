package com.consume.api.restapiconsume.model.worldbank;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Value {
    GDP_CURRENT_US, MOZAMBIQUE, POPULATION_TOTAL;

    @JsonValue
    public String toValue() {
        switch (this) {
            case GDP_CURRENT_US:
                return "GDP (current US$)";
            case MOZAMBIQUE:
                return "Mozambique";
            case POPULATION_TOTAL:
                return "Population, total";
        }
        return null;
    }

    @JsonCreator
    public static Value forValue(String value) throws IOException {
        if (value.equals("GDP (current US$)"))
            return GDP_CURRENT_US;
        if (value.equals("Mozambique"))
            return MOZAMBIQUE;
        if (value.equals("Population, total"))
            return POPULATION_TOTAL;
        throw new IOException("Cannot deserialize Value");
    }
}
