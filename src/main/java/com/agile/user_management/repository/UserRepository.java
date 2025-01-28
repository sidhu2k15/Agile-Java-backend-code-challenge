package com.agile.user_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.user_management.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}
