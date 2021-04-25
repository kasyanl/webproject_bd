package kasyan.service;

import kasyan.bean.Person;

import kasyan.repository.RepositoryService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class PersonService extends RepositoryService{

    // проверка на совпадение login и password
    public boolean verificationOfAuthenticity(String login, String password) throws SQLException {
        List<Person> personList = findAllPerson();
        for (Person person : personList) {
            if (login.equals(person.getLogin()) && password.equals(person.getPassword())) return true;
        }
        return false;
    }

    // отправка запроса на получение всех пользователей их БД
    public List<Person> findAllPerson() throws SQLException {
        String select = "SELECT id, login, password FROM person";
        return findPersonFromBD(select);
    }
}