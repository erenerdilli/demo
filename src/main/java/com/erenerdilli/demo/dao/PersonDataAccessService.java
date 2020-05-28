package com.erenerdilli.demo.dao;

import com.erenerdilli.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {

        final String sql = "select id, name from person";
        List<Person> people = jdbcTemplate.query(sql, (resultSet, i) -> {
            return new Person(UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name"));
        });

        return people;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        final String sql = "select id, name from person where id = ?";

        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            return new Person(UUID.fromString(resultSet.getString("id")),
                    resultSet.getString("name"));
        });

        return Optional.ofNullable(person);
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }
}
