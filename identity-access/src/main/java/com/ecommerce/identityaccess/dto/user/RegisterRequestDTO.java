package com.ecommerce.identityaccess.dto.user;

import com.ecommerce.identityaccess.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequestDTO {

    private String username;
    private String email;
    private String password;
    private Role role;

}
