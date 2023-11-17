package com.ecommerce.ecommerce.service;


import com.ecommerce.ecommerce.dto.APIResponseDTO;
import com.ecommerce.ecommerce.dto.UserDTO;
import com.ecommerce.ecommerce.model.Users;
import com.ecommerce.ecommerce.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AdminService {

    private UsersRepository usersRepository;

    public Page<UserDTO> searchUsers(String searchTerm, int page, int size) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return usersRepository.findAllUsers(PageRequest.of(page, size));
        } else {
            return usersRepository.findByUsernameContainingOrEmailContaining(searchTerm, searchTerm, PageRequest.of(page, size));
        }
    }

    public APIResponseDTO deleteUser(Long userID) {
        try {
            Optional<Users> user = usersRepository.findById(userID);
            if (user.isEmpty()) {
                log.info("Attempted to delete a user that does not exist with ID: {}", userID);
                return APIResponseDTO.builder()
                        .message("User not found")
                        .success(false)
                        .build();
            }
            usersRepository.deleteById(userID);
            log.info("Deleted user with ID: {}", userID);
            return APIResponseDTO.builder()
                    .message("Successfully deleted")
                    .success(true)
                    .build();

        } catch (Exception e) {
            log.error("Error deleting user: ", e);
            return APIResponseDTO.builder()
                    .message("Error occurred during deletion")
                    .success(false)
                    .build();
        }
    }
}
