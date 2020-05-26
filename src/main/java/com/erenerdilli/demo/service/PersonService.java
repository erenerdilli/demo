package com.erenerdilli.demo.service;

import com.erenerdilli.demo.dao.PersonDAO;
import com.erenerdilli.demo.model.Person;

public class PersonService {

    private final PersonDAO personDAO;

    public PersonService(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public int addPerson(Person person) {

        return personDAO.insertPerson(person);
    }

}
