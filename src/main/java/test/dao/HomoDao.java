package test.dao;

import test.domain.Homo;

import java.util.List;

public interface HomoDao {
    void add(Homo homo);
    List<Homo> list();
}
