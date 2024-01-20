package com.sda.auctionsite.startup;

import com.sda.auctionsite.services.AuctionService;
import com.sda.auctionsite.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartUpRunner implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuctionService auctionService;

    public StartUpRunner(CategoryService categoryService, AuctionService auctionService) {
        this.categoryService = categoryService;
        this.auctionService = auctionService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.createInitialData();
        auctionService.createInitialData();
    }
}
