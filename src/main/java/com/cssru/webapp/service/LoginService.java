package com.cssru.webapp.service;

import com.cssru.webapp.domain.Login;
import com.cssru.webapp.domain.Login;

import java.util.List;

public interface LoginService {
    Login get(String loginName);
    void add(Login login);
    List<Login> list();
}
