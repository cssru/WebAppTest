package test.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.dao.LoginDao;
import test.domain.Login;

import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {
    @Autowired
    SessionFactory sessionFactory;

    public Login get(String userName) {
        return (Login) sessionFactory
                .getCurrentSession()
                .createQuery("from Login as u where u.login = :loginName")
                .setParameter("loginName", userName)
                .uniqueResult();
    }

    public void add(Login login) {
        sessionFactory.getCurrentSession().save(login);
    }

    public List<Login> list() {
        return sessionFactory.getCurrentSession().createQuery("from Login").list();
    }
}
