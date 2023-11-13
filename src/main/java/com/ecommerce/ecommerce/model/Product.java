package com.ecommerce.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Table(name = "products")
public class Product {
    //TODO Product - Review/Rating Relationship:
    //TODO One-to-Many: A Product can have multiple Reviews/Ratings, but each Review/Rating is associated with one Product.

    //TODO Product - Order Relationship:
    //TODO Many-to-Many: An Order can contain multiple Products, and a Product can be part of multiple Orders.

    //TODO Product - Category Relationship:
    //TODO One-to-Many: A Category can have multiple Products, but each Product belongs to only one Category.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderDetails> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<Review> reviews;
}
