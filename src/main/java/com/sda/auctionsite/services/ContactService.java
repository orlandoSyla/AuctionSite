package com.sda.auctionsite.services;

import com.sda.auctionsite.dto.ContactRequest;
import com.sda.auctionsite.entities.Contact;
import com.sda.auctionsite.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ContactService {
    protected final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public String save(ContactRequest request) {
        if (request == null)
            return "Please provide required information!";

        if (request.getTitle() == null || request.getTitle().isBlank()) {
            return "Title should not be empty!";
        }

        if (request.getEmail() == null || request.getEmail().isBlank()) {
            return "Email should not be empty!";
        }

        if (request.getDescription() == null || request.getDescription().isBlank()) {
            return "Description should not be empty!";
        }

        Contact dbItem = new Contact();
        dbItem.setTitle(request.getTitle());
        dbItem.setEmail(request.getEmail());
        dbItem.setDescription(request.getDescription());
        dbItem.setCreatedAt(Instant.now());
        contactRepository.save(dbItem);

        return "OK";
    }
}
