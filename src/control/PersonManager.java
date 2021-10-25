package control;

import model.Person;
import storage.PersonFileManager;

import java.util.ArrayList;
import java.util.List;

public class PersonManager implements IGeneralManager<Person> {


    private List<Person> personList;
    private PersonFileManager personFileManager;

    public PersonFileManager getPersonFileManager() {
        return personFileManager;
    }

    public void setPersonFileManager(PersonFileManager personFileManager) {
        this.personFileManager = personFileManager;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public void saveList(Person person) {
        personList.add(person);
    }

    @Override
    public void removeByIndex(int index) {
        personList.remove(index);
    }

    @Override
    public void updateByIndex(int index, Person person) {
        personList.set(index, person);
    }

    @Override
    public Person searchById(String id) {
        Person person = null;
        for (int i = personList.size()-1; i >= 0; i--) {
            if (personList.get(i).getId().equalsIgnoreCase(id)) {
                person = personList.get(i);
                break;
            }
        }
        return person;
    }

    @Override
    public void showAllList() {
        for (Person person: personList
             ) {
            System.out.println(person);
        }
    }
}
