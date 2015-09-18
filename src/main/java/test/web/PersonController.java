package test.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import test.domain.Person;
import test.dto.PersonDto;
import test.service.PersonService;

import javax.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/person.add", method = RequestMethod.POST)
    public String addHomo(@Valid PersonDto personDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("personDto", personDto);
            return "index";
        }

        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return "index";
        }

        Person person = new Person();
        person.setSurname(personDto.getSurname());
        person.setName(personDto.getName());
        person.setLastname(personDto.getLastname());
        person.setAge(personDto.getAge());
        personService.add(person);
        model.addAttribute("personDto", new PersonDto());

        model.addAttribute("allPersons", personService.list());
        return "index";
    }
}
