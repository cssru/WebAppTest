package com.cssru.webapp.service;

import com.cssru.webapp.domain.Person;
import com.cssru.webapp.domain.Person;

import java.util.List;

public interface PersonService {
    void add(Person person);
    List<Person> list();
    void delete(Long id);
}
