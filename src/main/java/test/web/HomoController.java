package test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.domain.Homo;
import test.dto.HomoDto;
import test.service.HomoService;

import javax.validation.Valid;

@Controller
public class HomoController {

    @Autowired
    private HomoService homoService;


    @RequestMapping(value = "/homo.add", method = RequestMethod.POST)
    public String addHomo(@Valid HomoDto homoDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("homoDto", homoDto);
            return "index";
        }

        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return "index";
        }

        Homo homo = new Homo();
        homo.setSurname(homoDto.getSurname());
        homo.setName(homoDto.getName());
        homo.setLastname(homoDto.getLastname());
        homo.setAge(homoDto.getAge());
        homoService.add(homo);
        model.addAttribute("homoDto", new HomoDto());

        model.addAttribute("allHomo", homoService.list());
        return "index";
    }
}
