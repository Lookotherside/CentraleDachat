package com.centraledachat.demo.Service;

import com.centraledachat.demo.Model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
