package com.cssru.webapp.dao.impl;

import com.cssru.webapp.dao.LoginDao;
import com.cssru.webapp.domain.Login;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LoginDaoImpl implements LoginDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Login get(String userName) {
        return (Login) sessionFactory
                .getCurrentSession()
                .createQuery("from Login as u where u.login = :loginName")
                .setParameter("loginName", userName)
                .uniqueResult();
    }

    @Override
    public void add(Login login) {
        sessionFactory.getCurrentSession().save(login);
    }

    @Override
    public List<Login> list() {
        return sessionFactory.getCurrentSession().createQuery("from Login").list();
    }

}
