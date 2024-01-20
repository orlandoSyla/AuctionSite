package com.sda.auctionsite.controllers;

import com.sda.auctionsite.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sda.auctionsite.services.HomeService;


@Controller
@RequestMapping("/")
public class  HomeController {
    protected final CategoryService categoryService;

    public HomeController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("")
    public String index(ModelMap modelMap) {
        modelMap.put("categories", categoryService.getCategories());
        return "website/home-index";
    }
}
