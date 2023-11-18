package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dto.OrderDetailsDTO;
import com.ecommerce.ecommerce.model.OrderDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderDetailsMapper {
    @Mapping(source = "product.id", target = "productId")
    OrderDetailsDTO orderDetailsToOrderDetailsDTO(OrderDetails orderDetails);
}
