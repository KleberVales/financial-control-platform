package com.ecommerce.identityaccess.entity;

import com.ecommerce.identityaccess.dto.user.RegisterRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;

    @Column(nullable = false, unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="user_role")
    private Role role;

    public User(RegisterRequestDTO dto) {
        this.username = dto.getUsername();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.role = dto.getRole();
    }
}
