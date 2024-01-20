package com.sda.auctionsite.entities;


import com.sda.auctionsite.enums.AuctionStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "as_auction")
public class Auction extends BaseEntity {

    @NotBlank
    @Column(name = "title")
    protected String title;

    @NotBlank
    @Column(name = "description")
    protected String description;

    @Min(0)
    @Column(name = "price")
    protected double price;

    @Min(0)
    @Column(name = "minimum_sell_price")
    protected double minimumSellPrice;

    @Min(1)
    @Column(name = "duration")
    protected int duration;

    @Column(name = "activated_at")
    protected Instant activatedAt;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    protected AuctionStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    protected Category category;


    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    protected User user;

}
