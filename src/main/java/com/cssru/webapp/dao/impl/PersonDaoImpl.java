package com.cssru.webapp.dao.impl;

import com.cssru.webapp.dao.PersonDao;
import com.cssru.webapp.domain.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Person person) {
        sessionFactory
                .getCurrentSession()
                .save(person);
    }

    @Override
    public List<Person> list() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Person")
                .list();
    }

    @Override
    public void delete(Long id) {
        Person persistentPerson = sessionFactory
                .getCurrentSession()
                .get(Person.class, id);
        if (persistentPerson != null) {
            sessionFactory
                    .getCurrentSession()
                    .delete(persistentPerson);
        }
    }

}
