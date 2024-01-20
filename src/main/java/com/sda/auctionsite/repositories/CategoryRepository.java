package com.sda.auctionsite.repositories;

import com.sda.auctionsite.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(" from Category c where lower(c.title) = lower(:title) ")
    List<Category> findByTitle(@Param("title") String title);

    @Query(" from Category c where c.deleted = false")
    List<Category> getAllNotDeleted();
}
