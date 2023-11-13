package com.ecommerce.ecommerce.service;


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
@Slf4j
@AllArgsConstructor
public class AdminService {

    private UsersRepository usersRepository;

    public List<Users> searchAllUsers(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        return usersRepository.findAll(pageable).getContent();
    }

    public List<Users> searchUserByFilter(String username, String email) {
        if (username == null ) { //|| username.isEmpty()
            return usersRepository.findByEmail(email)
                    .stream()
                    .collect(Collectors.toList());

        } else if (email == null ) { //|| email.isEmpty()
            return usersRepository.findByUsername(username)
                    .stream()
                    .collect(Collectors.toList());
        }
        throw new IllegalArgumentException("Both username and email cannot be empty");
    }

}
