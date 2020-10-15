package com.filmrating.demo.service;

import com.filmrating.demo.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(int theId);

    public void save(User theEmployee);

    public void deleteById(int theId);

    public User findByUsername(String username);


}
