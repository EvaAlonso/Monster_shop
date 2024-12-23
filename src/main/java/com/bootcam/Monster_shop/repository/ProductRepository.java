package com.bootcam.Monster_shop.repository;

import com.bootcam.Monster_shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
