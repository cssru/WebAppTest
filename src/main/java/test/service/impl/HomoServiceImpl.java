package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import test.dao.HomoDao;
import test.domain.Homo;
import test.service.HomoService;

import java.util.List;

/**
 * Created by css on 14.09.15.
 */
@Service
public class HomoServiceImpl implements HomoService {
    @Autowired
    private HomoDao homoDao;

    @Transactional
    public void add(Homo homo) {
        homoDao.add(homo);
    }

    @Transactional
    public List<Homo> list() {
        return homoDao.list();
    }
}
