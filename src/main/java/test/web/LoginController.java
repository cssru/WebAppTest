package test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import test.service.PersonService;

@Controller
public class LoginController {

    @Autowired
    PersonService personService;

    @RequestMapping("/")
    public String login(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            model.addAttribute("people", personService.list());
        }
        return "index";
    }

}
