package com.ecommerce.ecommerce.mapper;

import com.ecommerce.ecommerce.dto.OrderDTO;
import com.ecommerce.ecommerce.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(uses = OrderDetailsMapper.class, componentModel = "spring")
public interface OrderMapper {

    OrderDTO orderToOrderDTO(Order order);
}
