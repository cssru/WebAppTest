package test.service;

import org.springframework.stereotype.Service;
import test.domain.Homo;

import java.util.List;

@Service
public interface HomoService {
    void add(Homo homo);
    List<Homo> list();
}
