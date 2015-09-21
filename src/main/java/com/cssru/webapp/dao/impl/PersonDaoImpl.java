package com.cssru.webapp.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cssru.webapp.dao.PersonDao;
import com.cssru.webapp.domain.Person;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    public List<Person> list() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }
}
