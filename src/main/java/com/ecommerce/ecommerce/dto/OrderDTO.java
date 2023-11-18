package com.ecommerce.ecommerce.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class OrderDTO {
    private Long id;
    private List<OrderDetailsDTO> orderDetails;
}
