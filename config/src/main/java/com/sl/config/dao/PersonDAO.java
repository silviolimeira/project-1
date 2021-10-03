package com.sl.config.dao;

import java.util.List;

import com.sl.config.model.Person;

public interface PersonDAO {
    List<Person> getPersonById(Long id);

    List<Person> getAllPersons();

    boolean deletePerson(Person person);

    boolean updatePerson(Person person);

    boolean createPerson(Person person);
}
