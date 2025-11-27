package com.enterprise.java.repositories;

import com.enterprise.java.models.MyUserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUserDetails, Integer> {
    public MyUserDetails findByUsername(String username);
}
