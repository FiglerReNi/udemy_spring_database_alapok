package com.example.database.util;

import com.example.database.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class CustomRowMapper {

    public static RowMapper<Person> personRowMapper = (ResultSet resultSet, int i)  -> {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setLocation(resultSet.getString("location"));
        person.setBirthday(resultSet.getDate("birthday").toLocalDate());
        return person;
    };
}
