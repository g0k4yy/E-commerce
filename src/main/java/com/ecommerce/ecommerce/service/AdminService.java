package com.ecommerce.ecommerce.service;


import com.ecommerce.ecommerce.dto.DeleteResponseDTO;
import com.ecommerce.ecommerce.dto.DetailedUserDTO;
import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.exception.UserNotFoundException;
import com.ecommerce.ecommerce.mapper.UserMapper;
import com.ecommerce.ecommerce.model.Users;
import com.ecommerce.ecommerce.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AdminService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public Page<UserDTO> searchUsers(String searchTerm, int page, int size) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return usersRepository.findAllUsers(PageRequest.of(page, size));
        } else {
            return usersRepository.findByUsernameContainingOrEmailContaining(searchTerm, searchTerm, PageRequest.of(page, size));
        }
    }

    public DeleteResponseDTO deleteUser(Long userID) {
        Users user = usersRepository.findById(userID)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userID));

        usersRepository.deleteById(userID);
        log.info("Deleted user with ID: {}", userID);
        return DeleteResponseDTO.builder()
                .message("Successfully deleted")
                .success(true)
                .build();
    }

    public DetailedUserDTO getUserDetailed(Long userID) {
        Users user = usersRepository.findById(userID)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userID));
        return userMapper.userToDetailedUserDTO(user);
    }
}
