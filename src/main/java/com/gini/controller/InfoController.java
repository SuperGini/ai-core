package com.gini.controller;

import com.gini.dto.CarResponse;
import com.gini.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InfoController {

    private final InfoService infoService;

    @PostMapping("/cars")
    public CarResponse getCar(@RequestParam String car) {
        return infoService.getResponse(car);
    }

}