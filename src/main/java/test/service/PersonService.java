package test.service;

import org.springframework.stereotype.Service;
import test.domain.Person;

import java.util.List;

public interface PersonService {
    void add(Person person);
    List<Person> list();
}
