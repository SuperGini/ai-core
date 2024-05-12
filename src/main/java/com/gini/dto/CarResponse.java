package com.gini.dto;


import java.util.List;

public record CarResponse(
        String manufacturer,
        List<CarModel> carModels

) {
}
