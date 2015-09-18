package test.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import test.dao.HomoDao;
import test.domain.Homo;

import java.util.List;

@Repository
public class HomoDaoImpl implements HomoDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(Homo homo) {
        sessionFactory.getCurrentSession().save(homo);
    }

    public List<Homo> list() {
        return sessionFactory.getCurrentSession().createQuery("from Homo").list();
    }
}
