package com.spring.crud.boot.project.web_data.services;

import com.spring.crud.boot.project.web_data.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    User getUserById(int id);

    List<User> getAllUsers();
}
