package com.ecommerce.ecommerce.controller;


import com.ecommerce.ecommerce.dto.AuthResponseDto;
import com.ecommerce.ecommerce.dto.UserRegistrationDTO;
import com.ecommerce.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(@Valid @RequestBody UserRegistrationDTO dto){
        AuthResponseDto responseDto = userService.registerUser(dto);
        return ResponseEntity.ok(responseDto);
    }

}
