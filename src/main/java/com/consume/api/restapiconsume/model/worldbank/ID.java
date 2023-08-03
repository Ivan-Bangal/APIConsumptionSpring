package com.consume.api.restapiconsume.model.worldbank;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ID {
    MZ, SP_POP_TOTL, NY_GDP_MKTP_CD;

    @JsonValue
    public String toValue() {
        switch (this) {
            case MZ:
                return "MZ";
            case SP_POP_TOTL:
                return "SP.POP.TOTL";
            case NY_GDP_MKTP_CD:
                return "NY.GDP.MKTP.CD";
        }
        return null;
    }

    @JsonCreator
    public static ID forValue(String value) throws IOException {
        if (value.equals("MZ"))
            return MZ;
        if (value.equals("SP.POP.TOTL"))
            return SP_POP_TOTL;
        if (value.equals("NY.GDP.MKTP.CD"))
            return NY_GDP_MKTP_CD;
        throw new IOException("Cannot deserialize ID");
    }
}
