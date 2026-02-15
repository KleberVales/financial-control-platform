package com.ecommerce.identityaccess.controller;

import com.ecommerce.identityaccess.dto.auth.AuthRequestDTO;
import com.ecommerce.identityaccess.dto.auth.AuthResponseDTO;
import com.ecommerce.identityaccess.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public AuthResponseDTO auth(@RequestBody AuthRequestDTO authRequestDTO) {

        return authService.login(authRequestDTO);

    }
}
