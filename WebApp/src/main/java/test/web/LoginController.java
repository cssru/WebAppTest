package test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import test.dto.HomoDto;
import test.service.HomoService;

/**
 * Created by css on 14.09.15.
 */
@Controller
public class LoginController {

    @Autowired
    HomoService homoService;

    @RequestMapping("/")
    public String login(Model model) {
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            model.addAttribute("allHomo", homoService.list());
            model.addAttribute("homoDto", new HomoDto());
        }
        return "index";
    }

    @RequestMapping("/badlogin")
    public String badLogin() {
        return "badlogin";
    }

}
