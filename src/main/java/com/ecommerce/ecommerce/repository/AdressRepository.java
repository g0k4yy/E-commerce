package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdressRepository extends JpaRepository <Address,Long> {
}
