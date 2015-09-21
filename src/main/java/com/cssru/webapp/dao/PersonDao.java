package com.cssru.webapp.dao;

import com.cssru.webapp.domain.Person;

import java.util.List;

public interface PersonDao {
    void add(Person person);
    List<Person> list();
}
