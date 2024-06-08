package com.gini.controller;

import com.gini.dto.Request;
import com.gini.dto.SpringResponse;
import com.gini.service.RagSpringService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class RagSpringController {

    private final RagSpringService ragService;

    @PostMapping("/question")
    public SpringResponse getAnswer(@RequestBody Request request) {
        return ragService.getAnswer(request);
    }
}
