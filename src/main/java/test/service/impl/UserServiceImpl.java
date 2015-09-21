package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import test.dao.UserDao;
import test.domain.User;
import test.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    public User get(String loginName) {
        return userDao.get(loginName);
    }

    public void add(User user) {
        userDao.add(user);
    }

    public List<User> list() {
        return userDao.list();
    }

}
