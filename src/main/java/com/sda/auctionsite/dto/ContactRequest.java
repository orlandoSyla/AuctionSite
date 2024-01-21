package com.sda.auctionsite.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactRequest {
    protected String title;
    protected String email;
    protected String description;
}
