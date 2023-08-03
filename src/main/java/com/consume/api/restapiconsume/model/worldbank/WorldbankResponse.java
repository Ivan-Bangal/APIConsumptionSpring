package com.consume.api.restapiconsume.model.worldbank;

import lombok.Data;

@Data
public class WorldbankResponse {
    public AdditionalWorldbankInfo purpleWorldbankResponseValue;
    public WorldbankResponseElement[] elementArray;
}
