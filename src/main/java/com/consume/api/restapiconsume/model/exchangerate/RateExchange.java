package com.consume.api.restapiconsume.model.exchangerate;
import java.util.Map;

import lombok.Data;

@Data
public class RateExchange{
    public String result;
    public String documentation;
    public String terms_of_use;
    public int time_last_update_unix;
    public String time_last_update_utc;
    public int time_next_update_unix;
    public String time_next_update_utc;
    public String base_code;
    public Map<String,Double> conversion_rates;
}
