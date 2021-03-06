package com.cssru.webapp.web;

import com.cssru.webapp.domain.Person;
import com.cssru.webapp.dto.PersonDto;
import com.cssru.webapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/person.add", method = RequestMethod.POST)
    public String addPerson(@Valid PersonDto personDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "index";
        }

        Person person = new Person();
        person.setSurname(personDto.getSurname());
        person.setName(personDto.getName());
        person.setLastname(personDto.getLastname());
        person.setAge(personDto.getAge());
        personService.add(person);
        model.addAttribute("personDto", new PersonDto());

        model.addAttribute("people", personService.list());
        return "admin/index";
    }

    @RequestMapping(value = "/person.delete/{id}", method = RequestMethod.POST)
    public String deletePerson(@PathVariable("id") Long id, Model model) {
        personService.delete(id);
        model.addAttribute("people", personService.list());
        model.addAttribute("personDto", new PersonDto());
        return "admin/index";
    }

}
