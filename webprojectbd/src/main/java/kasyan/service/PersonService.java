package kasyan.service;

import kasyan.bean.Person;

import kasyan.repository.RepositoryService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends RepositoryService implements InitializingBean {

    // проверка на совпадение login и password
    public boolean verificationOfAuthenticity(String login, String password) {
        List<Person> personList = findAllPerson();
        for (Person person : personList) {
            if (login.equals(person.getLogin()) && password.equals(person.getPassword())) return true;
        }
        return false;
    }

    // получение всех пользователей их БД
    public List<Person> findAllPerson() {
        String select = "SELECT id, login, password FROM person";
        return findPersonFromBD(select);
    }

    @Override
    public void afterPropertiesSet(){
    }
}


