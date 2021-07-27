package com.system.tinyurl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.system.tinyurl.model.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
