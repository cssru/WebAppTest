package test.service;

import test.domain.Login;

import java.util.List;

public interface LoginService {
    Login get(String loginName);
    void add(Login login);
    List<Login> list();
}
