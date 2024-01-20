package com.sda.auctionsite.repositories;

import com.sda.auctionsite.entities.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    @Query(" from Auction a where lower(a.title) = lower(:title) ")
    List<Auction> findAuctionBy(@Param("title") String title);

    @Query(" from Auction a where a.deleted = false")
    List<Auction> getAuctionByActive();

}
