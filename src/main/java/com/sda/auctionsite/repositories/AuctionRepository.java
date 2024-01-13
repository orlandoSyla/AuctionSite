package com.sda.auctionsite.repositories;

import com.sda.auctionsite.entities.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

}
