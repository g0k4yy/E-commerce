package com.ecommerce.ecommerce.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class ReviewDTO {
    private Long id;
    private String title;
    private String content;
    private int rating;
    private Long productId; // Assuming you only need the product ID

}

