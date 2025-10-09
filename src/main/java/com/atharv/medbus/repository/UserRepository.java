package com.atharv.medbus.repository;

import com.atharv.medbus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
