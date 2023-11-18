package com.ecommerce.ecommerce.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteResponseDTO {
    private boolean success;
    private String message;
}
