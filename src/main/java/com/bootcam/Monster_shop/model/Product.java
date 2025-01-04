package com.bootcam.Monster_shop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private String imageUrl;
    private int reviewCount;
    private boolean featured;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Review> reviews;



}
