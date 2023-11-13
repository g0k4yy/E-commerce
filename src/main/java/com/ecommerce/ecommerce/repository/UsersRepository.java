package com.ecommerce.ecommerce.repository;


import com.ecommerce.ecommerce.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository <Users,Long> {
    @Override
    Page<Users> findAll(Pageable pageable);

    Optional<Users> findByUsername(String username);

    Optional<Users> findByEmail(String email);


}
