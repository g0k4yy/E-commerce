package com.ecommerce.ecommerce.mapper;

import org.mapstruct.Mapper;
import com.ecommerce.ecommerce.model.Address;
import com.ecommerce.ecommerce.dto.AddressDTO;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressDTO addressToAddressDTO(Address address);
}
