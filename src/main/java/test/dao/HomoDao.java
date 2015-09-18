package test.dao;

import test.domain.Homo;

import java.util.List;

public interface HomoDao {
    public void add(Homo homo);

    public List list();
}
