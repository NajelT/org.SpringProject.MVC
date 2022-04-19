package org.springProject.MVC.dao;

import org.springProject.MVC.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;

    private static final String URL = "jdbc:postgresql://localhost:5432/db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public Person show(int id) {
//        return people
//                .stream()
//                .filter(person-> person.getId() == id)
//                .findAny()
//                .orElse(null);
        return null;
    }

    public void save(Person person) {
//        person.setId(++PEOPLE_COUNT);
//        people.add(person);
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ", '" + person.getName()  +
                    "', " + person.getAge() + ",' " + person.getEmail() + "')";
            //INSERT PEOPLE Person VALUES(1, 'TOM', 18, 'tom@gmail.com')

            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person updatedPerson) {
//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);

    }

}
