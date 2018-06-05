package com.spring.ajax.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ajax.api.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
