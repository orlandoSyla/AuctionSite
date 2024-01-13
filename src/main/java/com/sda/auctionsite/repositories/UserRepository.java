package com.sda.auctionsite.repositories;

import com.sda.auctionsite.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
