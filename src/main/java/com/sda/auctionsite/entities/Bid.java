package com.sda.auctionsite.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Bid extends BaseEntity {

    @Column(name = "bid")
    protected double bid;

    @Column(name = "auction_id")
    protected double auctionId;

    @Column(name = "user_id")
    protected long userId;

    @ManyToOne
    @JoinColumn(name = "auction_id",insertable = false, updatable = false)
    protected Auction auction;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    protected User user;


}
