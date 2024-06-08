package com.gini.controller;

import com.gini.dto.Request;
import com.gini.dto.Response;
import com.gini.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class InfoController {

    private final InfoService infoService;

    @PostMapping("/info")
    private Response returnInfo(@RequestBody Request request) {
        return infoService.getInfoResponse(request.question());
    }

}
