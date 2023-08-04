package com.consume.api.restapiconsume.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.consume.api.restapiconsume.interfaces.WorldbankService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/worldbank")
public class WorldbankController {

    private final WorldbankService worldbankService;

    public WorldbankController(WorldbankService worldbankService) {
        this.worldbankService = worldbankService;
    }

    @GetMapping("/gdp/{countryCode}")
    public Mono<Object> getGDPData(@PathVariable String countryCode) {
        return worldbankService.getGDPData(countryCode);
    }

    @GetMapping("/population/{countryCode}")
    public Mono<Object> getPopulationData(@PathVariable String countryCode) {
        return worldbankService.getPopulationData(countryCode);
    }
}

