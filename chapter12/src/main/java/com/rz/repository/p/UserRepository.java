package com.rz.repository.p;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rz.domain.p.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
