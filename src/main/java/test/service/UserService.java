package test.service;

import test.domain.User;

import java.util.List;

public interface UserService {
    User get(String loginName);
    void add(User user);
    List<User> list();
}
