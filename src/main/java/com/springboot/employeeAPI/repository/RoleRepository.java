package com.springboot.employeeAPI.repository;

import com.springboot.employeeAPI.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
