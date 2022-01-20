package com.gunt.security.service;


import com.gunt.security.entity.User;
import java.util.List;


public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    User getById(Long id);

    void updateUser(User user);

    void getUserRoles(User user);

}
