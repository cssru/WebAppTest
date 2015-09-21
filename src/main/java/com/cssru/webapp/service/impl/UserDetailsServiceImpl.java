package com.cssru.webapp.service.impl;

import com.cssru.webapp.domain.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cssru.webapp.domain.Login;
import com.cssru.webapp.service.LoginService;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    LoginService loginService;

    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        Login login = loginService.get(userName);

        if (login == null) {
            throw new UsernameNotFoundException("Login not found");
        }

        UserDetails userDetails =
                new User(login.getLogin(),
                        login.getPassword(),
                        Collections.<GrantedAuthority>emptySet());

        return userDetails;
    }

}
