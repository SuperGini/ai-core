package com.gini.controller;

import com.gini.dto.Request;
import com.gini.service.RagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RagController {


    private final RagService ragService;

    @PostMapping("/question")
    public String getAnswer(@RequestBody Request request) {
        return ragService.getAnswer(request);

    }


}
