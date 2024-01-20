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
    public List<Auction>getAuction(){
        return auctionRepository.getAuctionByActive();
    }
    public boolean createInitialData() {
        // 1. Check if first exists in database
        List<Category> categories = categoryRepository.getAllNotDeleted();
        List<Auction> auctionRepositoryByTitle = auctionRepository.findAuctionByTitle("iPhone 16");
        if (auctionRepositoryByTitle.isEmpty()) {
            // 2. If it does not exist, create it
            Auction dbItem = new Auction();
            dbItem.setTitle("iPhone16");
            dbItem.setDescription("This is the item category of auctions");
            dbItem.setPrice(500);
            dbItem.setMinimumSellPrice(450);

            Category smartPhones = categories.stream().filter(o -> "Smartphones".equalsIgnoreCase(o.getTitle())).findFirst().orElseGet(() -> null);
            if (smartPhones == null)
                throw new RuntimeException("Smartphones category not found!");
            dbItem.setCategoryId(smartPhones.getId());
            dbItem.setCreatedAt(Instant.now());
            dbItem.setDuration(5);
            dbItem.setStatus(AuctionStatus.INSERTED);

            auctionRepository.save(dbItem);
        }

        return true;
    }
}
