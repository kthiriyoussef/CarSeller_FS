package com.youssef.users.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.youssef.users.entities.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername(String username);
User findByEmail(String email);
boolean existsByEmail(String email);
}