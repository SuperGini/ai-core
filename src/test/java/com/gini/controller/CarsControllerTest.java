package com.gini.controller;

import com.gini.dto.CarModel;
import com.gini.dto.CarResponse;
import com.gini.service.CarService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CarsController.class)
class CarsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CarService carService;

    @Test
    @DisplayName("returns HTTP status 200 when calling /cars endpoint")
    void shouldReturnOK() throws Exception {
        //given
        var carList = List.of(new CarModel("Focus", "150 km/h", "petrol", "1999"));
        var request = "Focus";

        CarResponse carResponse = new CarResponse("Ford", carList);

        given(carService.getResponse(request)).willReturn(carResponse);

        //when + then
        mockMvc.perform(
                        post("/cars").param("car", request)
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.manufacturer").value("Ford"));

    }

}
