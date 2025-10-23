package com.spring.crud.boot.project.web_data.controllers;

import com.spring.crud.boot.project.web_data.models.User;
import com.spring.crud.boot.project.web_data.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

    private UserService userService;

    @Autowired
    public AppController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsersPage(Model model) {
        System.out.println("ВЫЗОВ ПРИНЯТ");
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/update")
    public String usersUpdate(@RequestParam("userId") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/update")
    public String usersUpdate(@ModelAttribute("user") User user, @RequestParam("userId") int id) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String usersAdd(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String usersDelete(@RequestParam("userId") int id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

}
