package com.example.springbootmvc.userDao;

import com.example.springbootmvc.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    User update (User user);
    void delete(User user);
    User findById (long id);
}
