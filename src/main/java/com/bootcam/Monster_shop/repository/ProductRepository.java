package com.bootcam.Monster_shop.repository;

import com.bootcam.Monster_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductById(long id);
}
