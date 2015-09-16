package test.service;

import org.springframework.stereotype.Service;
import test.domain.Homo;

import java.util.List;

/**
 * Created by css on 14.09.15.
 */
@Service
public interface HomoService {
    public void add(Homo homo);
    public List<Homo> list();
}
