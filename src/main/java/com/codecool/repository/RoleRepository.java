package com.codecool.repository;

import org.springframework.context.annotation.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findByName(String name);
}
