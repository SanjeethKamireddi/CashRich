package com.example.coinapp.controller;

import com.example.coinapp.service.CoinMarketCapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/coins")
public class CoinController {

    private final CoinMarketCapService coinMarketCapService;

    public CoinController(CoinMarketCapService coinMarketCapService) {
        this.coinMarketCapService = coinMarketCapService;
    }

    @GetMapping("/data")
    public String getCoinData(@RequestParam String symbols) {
        return coinMarketCapService.getCoinData(symbols);
    }
}
