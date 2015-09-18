package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.dao.PersonDao;
import test.domain.Person;
import test.service.PersonService;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    public void add(Person person) {
        personDao.add(person);
    }

    @Transactional (readOnly = true)
    public List<Person> list() {
        return personDao.list();
    }
}
