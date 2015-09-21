package test.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        if (userName == null || !userName.equals("supervisor")) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }

        UserDetails userDetails =
                new User(userName,
                        "password", true, true, true, true,
                        new HashSet<GrantedAuthority>());

        return userDetails;
    }

}
