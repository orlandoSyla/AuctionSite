package com.sda.auctionsite.services;

import com.sda.auctionsite.entities.Auction;
import com.sda.auctionsite.entities.Category;
import com.sda.auctionsite.enums.AuctionStatus;
import com.sda.auctionsite.repositories.AuctionRepository;
import com.sda.auctionsite.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;
    private final CategoryRepository categoryRepository;

    public AuctionService(AuctionRepository auctionRepository, CategoryRepository categoryRepository) {
        this.auctionRepository = auctionRepository;
        this.categoryRepository = categoryRepository;
    }

    public boolean createInitialData() {
        List<Category> categories = categoryRepository.getAllNotDeleted();

        if (categories.isEmpty()) {
            throw new RuntimeException("Categories not found!");
        }

        createAuction("iPhone16", "Smartphones", "This is the Smartphones category of auctions", 1500, 750, AuctionStatus.INSERTED, 5);
        createAuction("Guitar", "Instruments", "This is the Instrument category of auctions", 700, 450, AuctionStatus.SOLD, 5);
        createAuction("Tank", "Vehicles", "This is the Vehicles category of auctions", 50000, 9500, AuctionStatus.ONGOING, 5);
        createAuction("Hoodie", "Clothes", "This is the Clothes category of auctions", 50, 12, AuctionStatus.UNSOLD, 1);
        createAuction("Glasses", "Accessories", "This is the Accessories category of auctions", 200, 75, AuctionStatus.FINISHED, 1);
        createAuction("Watches", "Accessories", "This is the accessories category of auctions", 500, 350, AuctionStatus.FINISHED, 1);

        return true;
    }

    private void createAuction(String title, String categoryTitle, String description, double price, double minimumSellPrice,
                               AuctionStatus status, int duration) {
        Category category = findCategoryByTitle(categoryTitle);

        Auction auction = new Auction();
        auction.setTitle(title);
        auction.setDescription(description);
        auction.setPrice(price);
        auction.setMinimumSellPrice(minimumSellPrice);
        auction.setCategoryId(category.getId());
        auction.setCreatedAt(Instant.now());
        auction.setDuration(duration);
        auction.setStatus(status);

        auctionRepository.save(auction);
    }

    private Category findCategoryByTitle(String categoryTitle) {
        return categoryRepository.getAllNotDeleted().stream()
                .filter(c -> categoryTitle.equalsIgnoreCase(c.getTitle()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(categoryTitle + " category not found!"));
    }
}

