package test.dao;

import test.domain.Login;

import java.util.List;

public interface LoginDao {
    Login get(String userName);
    void add(Login login);
    List<Login> list();
}
