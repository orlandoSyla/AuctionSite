package com.sda.auctionsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sda.auctionsite.services.HomeService;


@Controller
@RequestMapping("/")
public class  HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }


    @GetMapping("")
    public String index() {
        return "pages/home/index";
    }
}
