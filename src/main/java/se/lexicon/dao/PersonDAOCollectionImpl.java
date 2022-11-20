package se.lexicon.dao;

import se.lexicon.model.AppUser;
import se.lexicon.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDAOCollectionImpl implements PersonDAO{
    private List<Person> userStorage;

    public PersonDAOCollectionImpl()
    {
        userStorage = new ArrayList<Person>();
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(userStorage);
    }

    @Override
    public Person findById(int id) {
         for (Person person : userStorage)
             if (person.getId() == id)
                 return person;
         return null;
    }

    @Override
    public Person persist(Person person) {
        if (person == null) throw new IllegalArgumentException("person was null");
        Person result = findById(person.getId());
        if (result != null) throw new IllegalArgumentException("person was duplicate");
        userStorage.add(person);
        return person;
    }

    @Override
    public Person findByEmail(String email) {
        if (email == null) throw new IllegalArgumentException("email is null");
        for (Person person : userStorage)
            if (person.getEmail() == email)
                return person;
        return null;
    }

    @Override
    public void remove(int id) {
        Person result = findById(id);
        if (result != null)
            userStorage.remove(result);
        throw new IllegalArgumentException("Person is not available in the collection");
    }
}
