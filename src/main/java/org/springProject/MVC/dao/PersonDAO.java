package org.springProject.MVC.dao;

import org.springProject.MVC.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people=new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 23, "tom@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "George", 25, "george@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Alexander", 30, "alexander@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Leo", 21, "leon@gmail.com"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people
                .stream()
                .filter(person-> person.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId() == id);

    }

}
