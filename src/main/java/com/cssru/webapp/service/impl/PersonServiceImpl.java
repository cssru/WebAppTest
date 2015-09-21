package com.cssru.webapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cssru.webapp.dao.PersonDao;
import com.cssru.webapp.domain.Person;
import com.cssru.webapp.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    @Override
    public void add(Person person) {
        personDao.add(person);
    }

    @Transactional (readOnly = true)
    @Override
    public List<Person> list() {
        return personDao.list();
    }
}
