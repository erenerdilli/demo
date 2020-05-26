package com.erenerdilli.demo.dao;

import com.erenerdilli.demo.model.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDAO {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

    List<Person> selectAllPeople();
}
