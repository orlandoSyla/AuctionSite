package com.sda.auctionsite.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  long id;

    @Column(name = "deleted")
    protected boolean deleted;

    @Column(name = "created_at")
    protected Instant createdAt;
}
