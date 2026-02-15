package com.ecommerce.identityaccess.dto.auth;

import com.ecommerce.identityaccess.entity.User;
import com.ecommerce.identityaccess.service.UserService;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class UserDTO {

    private String username;
    private String email;
    private String password;
    private String role;


    public UserDTO(User user) {
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRole().toString();

    }
}
