package com.mrbjoern.cloudfitness.api.repository;

import com.mrbjoern.cloudfitness.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
