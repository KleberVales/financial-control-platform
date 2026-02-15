package com.ecommerce.identityaccess.service;

import com.ecommerce.identityaccess.dto.auth.UserDTO;
import com.ecommerce.identityaccess.dto.user.RegisterRequestDTO;
import com.ecommerce.identityaccess.dto.user.RegisterResponseDTO;
import com.ecommerce.identityaccess.entity.User;
import com.ecommerce.identityaccess.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }


    public RegisterResponseDTO register(RegisterRequestDTO dto) {

        String encodedPassword =
                passwordEncoder.encode(dto.getPassword());

        User user = new User();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(encodedPassword);
        user.setRole(dto.getRole());


        repo.save(user);

        RegisterResponseDTO responseDTO = new RegisterResponseDTO();

        responseDTO.setMessage("success");

        return responseDTO;

    }

    public User findByEmail(String email) {

        User user = repo.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Usuário não encontrado com email: " + email)
                );

        return user;


    }


}