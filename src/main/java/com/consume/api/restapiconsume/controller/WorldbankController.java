package com.consume.api.restapiconsume.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consume.api.restapiconsume.model.worldbank.WorldbankResponse;
import com.consume.api.restapiconsume.services.WorldbankService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/worldbank")
public class WorldbankController {

    private final WorldbankService worldbankService;

    public WorldbankController(WorldbankService worldbankService) {
        this.worldbankService = worldbankService;
    }

    @GetMapping("/gdp/{cityCode}")
    public Mono<Object> getGDPData(@PathVariable String cityCode) {
        return worldbankService.getGDPData(cityCode);
    }

    @GetMapping("/population/{cityCode}")
    public Mono<Object> getPopulationData(@PathVariable String cityCode) {
        return worldbankService.getPopulationData(cityCode);
    }
}

