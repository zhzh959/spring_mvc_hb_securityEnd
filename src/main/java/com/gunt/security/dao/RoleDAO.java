package com.gunt.security.dao;

import com.gunt.security.entity.Role;

import java.util.List;



public interface RoleDAO {
    List<Role> getAllRoles();
    void save(Role role);
    void delete(Role role);
    Role getById(Long id);
    Role getRoleByName(String rolename);
    Role createRoleIfNotFound(String name, long id);
    void addRole(Role role);


    }
