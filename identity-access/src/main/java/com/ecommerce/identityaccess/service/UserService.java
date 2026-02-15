package com.ecommerce.identityaccess.service;

import com.ecommerce.identityaccess.dto.user.RegisterRequestDTO;
import com.ecommerce.identityaccess.dto.user.RegisterResponseDTO;
import com.ecommerce.identityaccess.entity.User;
import com.ecommerce.identityaccess.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public RegisterResponseDTO register(RegisterRequestDTO dto) {

        User user = new User(dto);
        repo.save(user);

        RegisterResponseDTO responseDTO = new RegisterResponseDTO();

        responseDTO.setMessage("success");

        return responseDTO;



    }


}
