package test.service;

import test.domain.Person;

import java.util.List;

public interface PersonService {
    void add(Person person);
    List<Person> list();
}
