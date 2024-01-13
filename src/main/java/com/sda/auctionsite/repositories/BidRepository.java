package com.sda.auctionsite.repositories;

import com.sda.auctionsite.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid,Long> {

}
