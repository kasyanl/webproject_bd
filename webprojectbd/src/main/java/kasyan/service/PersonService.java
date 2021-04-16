package kasyan.service;

import kasyan.bean.Person;
import kasyan.repository.PersonDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static kasyan.repository.PersonRepository.personList;

@Service
public class PersonService {

    private PersonDataBase personDataBase;

    int id = 0;

    public boolean verificationOfAuthenticity(String login, String password) {
        for (Person person : personList) {
            if (login.equals(person.getLogin()) && password.equals(person.getPassword())) return true;
        }
        return false;
    }

       public static Person creatPerson(String login, String password) {
        int id = 0;
        if (!personList.isEmpty()) {
            int i = 1;
            for (Person person : personList) {
                if (person.getId() == i) i++;
                id = i;
            }
        } else id = personList.size();

        return new Person(id, login, password);
    }

    @Autowired
    public void setPersonDataBase(PersonDataBase personDataBase) {
        this.personDataBase = personDataBase;
    }
}


