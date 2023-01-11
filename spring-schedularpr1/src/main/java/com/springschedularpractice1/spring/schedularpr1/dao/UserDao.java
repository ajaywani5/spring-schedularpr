package com.springschedularpractice1.spring.schedularpr1.dao;

import com.springschedularpractice1.spring.schedularpr1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
