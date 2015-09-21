package test.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private String USER_NAME = "supervisor";
    private String PASSWORD = "password";

    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        if (USER_NAME.equals(userName)) {
            throw new UsernameNotFoundException("User not found");
        }

        UserDetails userDetails =
                new User(userName,
                        PASSWORD, true, true, true, true,
                        Collections.<GrantedAuthority>emptySet());

        return userDetails;
    }

}
