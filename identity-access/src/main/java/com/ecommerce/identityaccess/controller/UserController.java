package com.ecommerce.identityaccess.controller;

import com.ecommerce.identityaccess.dto.user.RegisterRequestDTO;
import com.ecommerce.identityaccess.dto.user.RegisterResponseDTO;
import com.ecommerce.identityaccess.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponseDTO registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) {

        return userService.register(registerRequestDTO);

    }
}
