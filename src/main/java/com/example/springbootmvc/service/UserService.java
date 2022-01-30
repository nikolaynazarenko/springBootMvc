package com.example.springbootmvc.service;

import com.example.springbootmvc.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    User update (User user);
    void delete(User user);
    User findById (long id);
}
