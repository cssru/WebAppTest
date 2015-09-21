package com.cssru.webapp.service.impl;

import com.cssru.webapp.dao.LoginDao;
import com.cssru.webapp.domain.Login;
import com.cssru.webapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cssru.webapp.dao.LoginDao;
import com.cssru.webapp.domain.Login;
import com.cssru.webapp.service.LoginService;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginDao loginDao;

    @Transactional (readOnly = true)
    public Login get(String loginName) {
        return loginDao.get(loginName);
    }

    @Transactional
    public void add(Login login) {
        loginDao.add(login);
    }

    @Transactional (readOnly = true)
    public List<Login> list() {
        return loginDao.list();
    }

}
