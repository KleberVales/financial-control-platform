package com.ecommerce.identityaccess.service;

import com.ecommerce.identityaccess.dto.auth.AuthRequestDTO;
import com.ecommerce.identityaccess.dto.auth.AuthResponseDTO;
import com.ecommerce.identityaccess.dto.auth.UserDTO;
import com.ecommerce.identityaccess.entity.User;
import com.ecommerce.identityaccess.securityconfig.JwtTokenProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserService userService;

    public AuthService(PasswordEncoder passwordEncoder,  JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    public AuthResponseDTO login(AuthRequestDTO authRequestDTO) {


        UserDTO userDTO = new  UserDTO(userService.findByEmail(authRequestDTO.getEmail()));

        if(!(passwordEncoder.matches(authRequestDTO.getPassword(), userDTO.getPassword()))){

            throw new BadCredentialsException("Incorrect password");

        }

        String token = jwtTokenProvider.generateToken(
                userDTO.getEmail(),
                userDTO.getPassword()
        );

        AuthResponseDTO authResponseDTO = new AuthResponseDTO();

        authResponseDTO.setUsername(userDTO.getUsername());
        authResponseDTO.setMessage("Success login");

        return authResponseDTO;

    }
}
