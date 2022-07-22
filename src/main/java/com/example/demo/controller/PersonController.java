package com.example.demo.controller;

import com.example.demo.service.PersonService;
import com.example.demo.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    private final PersonService personService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createPerson(@Valid @RequestBody Person person) {
        personService.createPerson(person);
    }

    @GetMapping
    public Iterable<Person> getPerson() {
        return personService.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(id, person);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

}
