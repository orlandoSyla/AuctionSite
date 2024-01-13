package com.sda.auctionsite.repositories;

import com.sda.auctionsite.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {

}
