package br.com.apidummy.Service;

import br.com.apidummy.exceptions.ResourceNotFoundException;
import br.com.apidummy.model.Person;
import br.com.apidummy.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public Person findById(Long id){
        logger.info("Finding One Person");

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id! " + id))
                ;
    }

    public List<Person> findAll(){

        return personRepository.findAll() ;
    }

    public Person create(Person person){

        logger.info("Creating a person");
        return personRepository.save(person);
    }
    public Person update(Person person){

        logger.info("updating a person");

        Person entity = personRepository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!" + person.getId()))
        ;

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        entity.setAddress(person.getAddress());

        return personRepository.save(person);
    }
    public void  delete(Long id){
        logger.info("deleting a person");

        Person entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!" + id))
                ;
        personRepository.delete(entity);
    }
}
