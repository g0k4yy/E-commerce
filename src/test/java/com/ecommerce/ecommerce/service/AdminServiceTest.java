package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.DetailedUserDTO;
import com.ecommerce.ecommerce.exception.UserNotFoundException;
import com.ecommerce.ecommerce.mapper.AddressMapper;
import com.ecommerce.ecommerce.mapper.OrderMapper;
import com.ecommerce.ecommerce.mapper.ReviewMapper;
import com.ecommerce.ecommerce.mapper.UserMapper;
import com.ecommerce.ecommerce.model.Users;
import com.ecommerce.ecommerce.repository.UsersRepository;
import jakarta.transaction.Transactional;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

public class AdminServiceTest {

    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private UserMapper userMapper; // Assuming you have a MapStruct mapper

    private AdminService adminService;
    @BeforeEach
    void setUp() {
         adminService = new AdminService(userRepository, userMapper);
    }
    @Test
    @Transactional
    void getUserDetailed() {
        Long userId = 1L; // Replace with the ID of the user inserted in data.sql

        DetailedUserDTO detailedUserDTO = adminService.getUserDetailed(userId);

        System.out.println(detailedUserDTO);
        // Then
        assertNotNull(detailedUserDTO);
        assertEquals("hcoopman1", detailedUserDTO.getUsername());
    }
    @Test
    @Transactional
    public void getUserDetailed_UserNotFound() {
        Long userId = -999L; // A non-existing user ID

        assertThrows(UserNotFoundException.class, () -> adminService.getUserDetailed(userId));
    }
}