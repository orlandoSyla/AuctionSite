package com.sda.auctionsite.startup;

import com.sda.auctionsite.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartUpRunner implements CommandLineRunner {
    private final CategoryService categoryService;

    public StartUpRunner(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.createInitialData();
    }
}
