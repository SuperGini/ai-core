package com.gini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import static com.gini.util.Constants.FORWARD_TO_INDEX_PAGE;

@Controller
public class PageController {

   // https://stackoverflow.com/questions/43913753/spring-boot-with-redirecting-with-single-page-angular2
    @GetMapping("/main")
    public String getMainPage() {
        return FORWARD_TO_INDEX_PAGE;
    }

    @GetMapping("/main/cars")
    public String getMainPageWithCars() {
        return FORWARD_TO_INDEX_PAGE;
    }

    @GetMapping("/main/info")
    public String getMainPageWithInfo() {
        return FORWARD_TO_INDEX_PAGE;
    }

}
