package com.ecommerce.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Street cannot be empty")
    @Size(min = 1, max = 100, message = "Street length must be between 1 and 100 characters")
    private String street;

    @NotBlank(message = "District cannot be empty")
    @Size(min = 1, max = 25, message = "District length must be between 1 and 50 characters")
    private String district;
    @NotBlank(message = "City cannot be empty")
    @Size(min = 1, max = 25, message = "City length must be between 1 and 50 characters")
    private String city;

    @NotBlank(message = "Country cannot be empty")
    @Size(min = 1, max = 40, message = "City length must be between 1 and 50 characters")
    private String country;

    @NotBlank(message = "Postal code cannot be empty")
    @Size(min = 4, max = 15, message = "Postal code length must be between 4 and 15 characters")
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

}