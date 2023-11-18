package com.ecommerce.ecommerce.repository;


import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Query("SELECT new com.ecommerce.ecommerce.dto.UserDTO(u.id, u.username, u.email, u.firstName, u.lastName) " +
            "FROM Users u WHERE u.username LIKE %:username% OR u.email LIKE %:email%")
    Page<UserDTO> findByUsernameContainingOrEmailContaining(
            @Param("username") String username,
            @Param("email") String email,
            Pageable pageable);

    @Query("SELECT new com.ecommerce.ecommerce.dto.UserDTO(u.id, u.username, u.email, u.firstName, u.lastName) FROM Users u")
    Page<UserDTO> findAllUsers(Pageable pageable);

}
