package com.ecommerce.ecommerce.service;

import com.ecommerce.ecommerce.dto.AuthResponseDto;
import com.ecommerce.ecommerce.dto.UserRegistrationDTO;
import com.ecommerce.ecommerce.model.Users;
import com.ecommerce.ecommerce.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {

    private final UsersRepository usersRepository;


    public AuthResponseDto registerUser(UserRegistrationDTO dto) {

        Users newUser = Users.builder()
                .username(dto.getUsername())
                .password(dto.getPassword()) //TODO ENCRYPTION
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();

        usersRepository.save(newUser);

        AuthResponseDto newResponseDto = AuthResponseDto.builder()
                .message("Registered successfully")
                .build();

        return newResponseDto;

    }

}
