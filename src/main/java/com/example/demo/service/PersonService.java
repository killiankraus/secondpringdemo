package com.example.demo.service;

import com.example.demo.repository.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PersonService {
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private PersonRepository personRepository;

    public void createPerson(Person person) {
        personRepository.save(person);
    }


    public Iterable<Person> findAll() {
        return personRepository.findAll();
    }

    public Person updatePerson(Long id, Person person) {
        Optional<Person> person1 = personRepository.findById(id);
        if (person1.isPresent()) {
            person.setId(id);
            return personRepository.save(person);
        } else {
            return null;
        }
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
