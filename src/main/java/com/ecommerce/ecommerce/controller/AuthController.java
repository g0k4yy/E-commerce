package com.ecommerce.ecommerce.controller;


import com.ecommerce.ecommerce.dto.AuthResponseDto;
import com.ecommerce.ecommerce.dto.UserRegistrationDTO;
import com.ecommerce.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class AuthController {

    public final UserService userService;

    @PostMapping
    public ResponseEntity<AuthResponseDto> register(@Valid @RequestBody UserRegistrationDTO dto){
        userService.registerUser(dto);
        return ResponseEntity.ok(userService.registerUser(dto));
    }

}
