package com.ecommerce.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class DetailedUserDTO {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private List<AddressDTO> addresses;
    private List<OrderDTO> orders;
    private List<ReviewDTO> reviews;

    public DetailedUserDTO() {

    }
}
