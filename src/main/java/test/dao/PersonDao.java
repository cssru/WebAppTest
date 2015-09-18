package test.dao;

import test.domain.Person;

import java.util.List;

public interface PersonDao {
    void add(Person person);
    List<Person> list();
}
