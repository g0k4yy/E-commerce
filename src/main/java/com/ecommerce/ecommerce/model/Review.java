package com.ecommerce.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private int rating;

    @ManyToOne
    private Users user;

    @ManyToOne
    private Product product;
}

