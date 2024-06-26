package com.springbasic.repository;

import com.springbasic.Customer;
import com.springbasic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Integer> {
}
