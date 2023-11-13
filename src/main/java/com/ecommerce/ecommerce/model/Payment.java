package com.ecommerce.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;

@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentMethod;
    private double amount;

    @OneToOne
    private Order order;

}
