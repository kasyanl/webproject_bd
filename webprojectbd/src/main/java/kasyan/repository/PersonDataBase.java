package kasyan.repository;

import kasyan.bean.Person;
import kasyan.exceptions.PersonNotFoundException;
import kasyan.service.PersonService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDataBase implements PersonRepository, InitializingBean {


    static {
       personList.add(PersonService.creatPerson("admin", "password"));
       personList.add(PersonService.creatPerson("admin1", "password1"));
       personList.add(PersonService.creatPerson("admin2", "password2"));
   }

        public List<Person> findAllPerson() {
        return personList;
    }

    public void savePerson(Person person) {
        personList.add(person);
    }

    public void deleteByIdPerson(int id) {
        personList.removeIf(nextPerson -> nextPerson.getId() == id);
    }

    public Person findByIdPerson(int id) throws PersonNotFoundException {
        for (Person person : personList) {
            if (person.getId() == id) return person;
        }
        throw new PersonNotFoundException("Person with id=" + id + " not found!");
    }

    @Override
    public void afterPropertiesSet() {
    }
}

