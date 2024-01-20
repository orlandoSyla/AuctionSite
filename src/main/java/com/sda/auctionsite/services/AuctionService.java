package com.sda.auctionsite.services;

import com.sda.auctionsite.entities.Auction;
import com.sda.auctionsite.entities.Category;
import com.sda.auctionsite.repositories.AuctionRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;

    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }
    public List<Auction>getAuction(){
        return auctionRepository.getAuctionByActive();
    }
    public boolean createInitialData() {
        // 1. Check if first category exists in database
        List<Auction> auctionRepositoryByTitle = auctionRepository.findAuctionBy("Active");
        if (auctionRepositoryByTitle.isEmpty()) {
            // 2. If it does not exist, create it
            Category dbItem = new Category();
            dbItem.setTitle("Item");
            dbItem.setCreatedAt(Instant.now());
            dbItem.setDescription("This is the item category of auctions");

            auctionRepository.save(dbItem);
        }

        return true;
    }
}
