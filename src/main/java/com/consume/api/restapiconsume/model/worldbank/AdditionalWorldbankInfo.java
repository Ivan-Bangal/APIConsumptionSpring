package com.consume.api.restapiconsume.model.worldbank;
import lombok.Data;

@Data
public class AdditionalWorldbankInfo {
    private long page;
    private long pages;
    private long perPage;
    private long total;
    private String sourceid;
    private String lastupdated;
}
