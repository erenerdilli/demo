package com.erenerdilli.demo.api;

import com.erenerdilli.demo.model.Person;
import com.erenerdilli.demo.service.PersonService;

public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public void addPerson(Person person) {
        personService.addPerson(person);
    }
}
