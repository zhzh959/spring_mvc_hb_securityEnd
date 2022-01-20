package com.gunt.security.dao;

import com.gunt.security.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    User getById(Long id);

    User getUserByName(String name);

    void updateUser(User user);






}
