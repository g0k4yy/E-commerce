package com.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class Users {

    //TODO User - Review/Rating Relationship:
    //TODO One-to-Many: A User can write multiple Reviews/Ratings, but each Review/Rating is associated with one User.

    //TODO User - Order Relationship:
    //TODO One-to-Many: A User can have multiple Orders, but each Order is associated with one User.

    //TODO User - Cart Relationship:
    //TODO One-to-One: Usually, a User has one Cart. This relationship can also be modeled as One-to-Many if you allow for multiple carts per user (e.g., saved carts).

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password; // Store a hashed password

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

}
