package com.ecommerce.identityaccess.dto.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequestDTO {

    private String email;
    private String password;

}
