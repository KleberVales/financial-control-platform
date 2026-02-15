package com.ecommerce.identityaccess.repository;

import com.ecommerce.identityaccess.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


}
