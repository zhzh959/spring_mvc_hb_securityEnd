package com.gunt.security.controllers;


import com.gunt.security.dao.RoleDAO;
import com.gunt.security.dao.RoleDAOImpl;
import com.gunt.security.entity.Role;
import com.gunt.security.entity.User;
import com.gunt.security.service.UserService;
import com.gunt.security.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private UserService userService;
    private final RoleDAO roleDAO;

    @Autowired
    public AdminController(UserService userService, RoleDAO roleDAO) {
        this.userService = userService;
        this.roleDAO = roleDAO;
    }

    @GetMapping("")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping(value = "/addNewUser")
    public String addNewUser(Model model, User user) {
        model.addAttribute("user", user);
        model.addAttribute("rolelist", roleDAO.getAllRoles());
        return "user-info";

    }

    @PostMapping(value = "/updateInfo")
    public String updateInfo(@ModelAttribute User user) {
        userService.getUserRoles(user);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/updateinfo")
    public String updateUser(@RequestParam("usId") Long id, User user, Model model) {
        user = userService.getById(id);
        model.addAttribute("user", user);
        model.addAttribute("rolelist", roleDAO.getAllRoles());
        return "updateInfo";
    }


    @PostMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.getUserRoles(user);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("usId") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
