package com.geekseat.abdul.technical.test.controller;

import com.geekseat.abdul.technical.test.dto.PersonDto;
import com.geekseat.abdul.technical.test.model.Person;
import com.geekseat.abdul.technical.test.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/")
public class WebController {

    @Autowired
    WebService service;

    @GetMapping({"/", "/"})
    public String index(Model model, @ModelAttribute PersonDto person) {
        model.addAttribute("person", person);
        return "index";
    }

    @GetMapping("/result")
    public String result(@RequestParam(value = "averageKilled") String averageKilled, Model model) {
        model.addAttribute("averageKilled", averageKilled);
        return "result";
    }

    @PostMapping("/solve")
    public String formNewSubmit(@ModelAttribute @Validated PersonDto person) {

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(person.getAgePersonA(), person.getDeathOnYearPersonA()));
        persons.add(new Person(person.getAgePersonB(), person.getDeathOnYearPersonB()));

        double result = service.calculateAverageNumberKilled(persons);
        return "redirect:/result?averageKilled=" + result;
    }
}
