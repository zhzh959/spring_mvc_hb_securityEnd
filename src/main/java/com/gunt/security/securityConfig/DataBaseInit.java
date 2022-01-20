package com.gunt.security.securityConfig;


import com.gunt.security.dao.RoleDAO;
import com.gunt.security.entity.Role;
import com.gunt.security.entity.User;
import com.gunt.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataBaseInit {
    private final UserService userService;
    private final RoleDAO roleDAO;

    @Autowired
    public DataBaseInit(UserService userService, RoleDAO roleDAO) {
        this.userService = userService;
        this.roleDAO = roleDAO;
    }

    @PostConstruct
    private void dataBaseInit() {

        Role roleAdmin = new Role("ADMIN");
        Role roleUser = new Role("USER");
        Set<Role> adminSet = new HashSet<>();
        Set<Role> userSet = new HashSet<>();

        roleDAO.addRole(roleAdmin);
        roleDAO.addRole(roleUser);

        adminSet.add(roleAdmin);
        adminSet.add(roleUser);
        userSet.add(roleUser);


        User admin = new User("admin", "Petrov", (byte) 22,
                "admin", adminSet );


        User user = new User("user", "Sergeev", (byte) 55,
                "user", userSet);


        userService.saveUser(admin);
        userService.saveUser(user);
    }

}
