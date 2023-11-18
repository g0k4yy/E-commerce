package com.ecommerce.ecommerce.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class OrderDetailsDTO {
    private Long id;
    private Long productId; // Assuming you only need the product ID
    private int quantity;
    private double price;
}
