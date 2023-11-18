package com.ecommerce.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.ecommerce.ecommerce.model.Review;
import com.ecommerce.ecommerce.dto.ReviewDTO;

@Mapper(componentModel = "spring")
public interface ReviewMapper {
    @Mapping(source = "product.id", target = "productId")

    ReviewDTO reviewToReviewDTO(Review review);
}
