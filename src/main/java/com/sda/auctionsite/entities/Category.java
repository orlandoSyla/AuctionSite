package com.sda.auctionsite.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "as_category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected  long id;

    @Column(name = "title")
    protected String title;

    @Column(name = "description")
    protected String description;
}
