package com.sda.auctionsite.repositories;

import com.sda.auctionsite.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
