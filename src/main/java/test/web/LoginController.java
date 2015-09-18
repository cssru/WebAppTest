package test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import test.dto.PersonDto;
import test.service.PersonService;

@Controller
public class LoginController {

    @Autowired
    PersonService personService;

    @RequestMapping("/")
    public String login(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            model.addAttribute("allPersons", personService.list());
            model.addAttribute("personDto", new PersonDto());
        }
        return "index";
    }

}
