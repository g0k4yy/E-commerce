package com.ecommerce.ecommerce.model;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Users user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetails> orderDetails;

}
