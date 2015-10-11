package com.cssru.webapp.service.impl;

import com.cssru.webapp.domain.Login;
import com.cssru.webapp.security.Role;
import com.cssru.webapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    LoginService loginService;

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        Login login = loginService.get(userName);

        if (login == null) {
            throw new UsernameNotFoundException("Login not found");
        }

        return "admin".equalsIgnoreCase(login.getLogin())
                ?
                new User(login.getLogin(),
                        login.getPassword(),
                        Arrays.asList(new SimpleGrantedAuthority(Role.ADMIN.name())))
                :
                new User(login.getLogin(),
                        login.getPassword(),
                        Arrays.asList(new SimpleGrantedAuthority(Role.USER.name())));
    }
}
