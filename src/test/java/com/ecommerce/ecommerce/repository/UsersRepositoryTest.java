package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.model.Users;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;
    @Test
    void findAll() {
        Page<Users> result = usersRepository.findAll(PageRequest.of(0, 10));
        assertThat(result).isNotNull();
        assertThat(result.getContent()).isNotEmpty();
    }
}