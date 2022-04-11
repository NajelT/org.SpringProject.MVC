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

        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "George"));
        people.add(new Person(++PEOPLE_COUNT, "Alexander"));
        people.add(new Person(++PEOPLE_COUNT, "Leo"));
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

}
