package edu.spring.data.repository;

import edu.spring.data.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findByName(String name);
}
