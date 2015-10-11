package com.cssru.webapp.web;

import com.cssru.webapp.dto.PersonDto;
import com.cssru.webapp.security.Role;
import com.cssru.webapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    PersonService personService;

    @RequestMapping("/")
    public String login(Model model) {
        if (isAuthenticated()) {
            model.addAttribute("people", personService.list());
            if (SecurityContextHolder
                    .getContext()
                    .getAuthentication()
                    .getAuthorities()
                    .contains(new SimpleGrantedAuthority(Role.ADMIN.name()))) {
                model.addAttribute("personDto", new PersonDto());
                return "admin/index";
            }
            return "user/index";
        }
        return "login";
    }

    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }
}
