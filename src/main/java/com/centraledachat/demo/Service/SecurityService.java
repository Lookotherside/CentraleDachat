package com.centraledachat.demo.Service;


public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}
