package com.spring.crud.boot.project.web_data.dao_classes;

import com.spring.crud.boot.project.web_data.models.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    void updateUser(User user);

    void deleteUserById(int id);

    User getUserById(int id);

    List<User> getAllUsers();
}
