package com.sda.auctionsite.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "as_contact")
public class Contact extends BaseEntity {

    @Column(name = "email")
    protected String email;

    @Column(name = "title")
    protected String title;

    @Column(name = "description")
    protected String description;
}
