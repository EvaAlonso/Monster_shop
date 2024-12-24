package com.bootcam.Monster_shop.repository;

import com.bootcam.Monster_shop.model.Product;
import com.bootcam.Monster_shop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {

}
