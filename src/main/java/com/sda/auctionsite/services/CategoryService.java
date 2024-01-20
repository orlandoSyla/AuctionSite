package com.sda.auctionsite.services;

import com.sda.auctionsite.entities.Category;
import com.sda.auctionsite.repositories.AuctionRepository;
import com.sda.auctionsite.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository, AuctionRepository auctionRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getCategories() {
        return categoryRepository.getAllNotDeleted();
    }


    public boolean createInitialData() {
        // 1. Check if first category exists in database
        List<Category> firstCategoryResult = categoryRepository.findByTitle("Smartphones");
        if (firstCategoryResult.isEmpty()) {
            // 2. If it does not exist, create it
            Category dbItem = new Category();
            dbItem.setTitle("Smartphones");
            dbItem.setCreatedAt(Instant.now());
            dbItem.setDescription("This is the smartphones category of auctions");

            categoryRepository.save(dbItem);
        }

        List<Category> secondCategoryResult = categoryRepository.findByTitle("Instruments");
        if (secondCategoryResult.isEmpty()) {
            // 2. If it does not exist, create it
            Category dbItem = new Category();
            dbItem.setTitle("Instruments");
            dbItem.setCreatedAt(Instant.now());
            dbItem.setDescription("This is the Instruments category of auctions");

            categoryRepository.save(dbItem);
        }


        List<Category> thirdCategoryResult = categoryRepository.findByTitle("Clothes");
        if (thirdCategoryResult.isEmpty()) {
            // 2. If it does not exist, create it
            Category dbItem = new Category();
            dbItem.setCreatedAt(Instant.now());
            dbItem.setTitle("Clothes");
            dbItem.setDescription("This is the Clothes category of auctions");

            categoryRepository.save(dbItem);
        }

        List<Category> fourthCategoryResult = categoryRepository.findByTitle("Vehicles");
        if (fourthCategoryResult.isEmpty()) {
            // 2. If it does not exist, create it
            Category dbItem = new Category();
            dbItem.setCreatedAt(Instant.now());
            dbItem.setTitle("Vehicles");
            dbItem.setDescription("This is the Vehicles category of auctions");

            categoryRepository.save(dbItem);
        }

        List<Category> fifthCategoryResult = categoryRepository.findByTitle("accessories");
        if (fifthCategoryResult.isEmpty()) {
            // 2. If it does not exist, create it
            Category dbItem = new Category();
            dbItem.setCreatedAt(Instant.now());
            dbItem.setTitle("Accessories");
            dbItem.setDescription("This is the Accesories category of auctions");

            categoryRepository.save(dbItem);

        }
        return true;
    }
}
