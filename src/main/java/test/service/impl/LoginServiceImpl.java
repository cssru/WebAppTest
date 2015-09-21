package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.dao.LoginDao;
import test.domain.Login;
import test.service.LoginService;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    public Login get(String loginName) {
        return loginDao.get(loginName);
    }

    public void add(Login login) {
        loginDao.add(login);
    }

    public List<Login> list() {
        return loginDao.list();
    }

}
