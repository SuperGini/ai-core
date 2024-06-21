package com.gini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.gini.util.Constants.FORWARD_TO_INDEX_PAGE;

@Controller
public class PageController {

    @GetMapping({
            "/main/spring",
            "/main/cars",
            "/main/info",
            "/main"

    })
    public String redirectToMainPage() {
        return FORWARD_TO_INDEX_PAGE;
    }

    @GetMapping("/test/*")
    public String test() {
        return FORWARD_TO_INDEX_PAGE;
    }

}
