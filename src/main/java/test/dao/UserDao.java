package test.dao;

import test.domain.User;

import java.util.List;

public interface UserDao {
    User get(String userName);
    void add(User user);
    List<User> list();
}
