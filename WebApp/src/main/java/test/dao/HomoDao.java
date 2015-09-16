package test.dao;

import test.domain.Homo;

import java.util.List;

/**
 * Created by css on 14.09.15.
 */
public interface HomoDao {
    public void add(Homo homo);
    public List list();
}
