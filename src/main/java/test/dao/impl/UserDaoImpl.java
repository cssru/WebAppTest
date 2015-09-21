package test.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import test.dao.UserDao;
import test.domain.User;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Autowired
    SessionFactory sessionFactory;

    public User get(String userName) {
        return (User) sessionFactory
                .getCurrentSession()
                .createQuery("from User as u where u.login = :loginName")
                .uniqueResult();
    }

    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public List<User> list() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
}
