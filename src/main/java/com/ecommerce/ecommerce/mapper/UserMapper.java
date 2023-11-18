package com.ecommerce.ecommerce.mapper;
import com.ecommerce.ecommerce.dto.DetailedUserDTO;
import com.ecommerce.ecommerce.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,uses = {AddressMapper.class, OrderMapper.class, ReviewMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    DetailedUserDTO userToDetailedUserDTO(Users user);
}
