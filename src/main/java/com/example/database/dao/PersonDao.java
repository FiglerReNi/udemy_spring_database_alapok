package com.example.database.dao;

import com.example.database.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAll(){
       return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id = ?",
                new BeanPropertyRowMapper<>(Person.class),
                id);
    }

    public List<Person> findByName(String name){
        return jdbcTemplate.query("select * from person where name = ?",
                new BeanPropertyRowMapper<>(Person.class),
                name);
    }

    public Person findByNameAndLocation(String name, String location){
        return jdbcTemplate.queryForObject("select * from person where name = ? and location = ?",
                new BeanPropertyRowMapper<>(Person.class),
                name, location);
    }

    public int deleteById(int id){
        return jdbcTemplate.update("delete from person where id = ?", id);
    }

    public int insert(Person person){
        return jdbcTemplate.update("insert into person (id, name, location, birthday ) VALUES(?,?,?,?)",
                person.getId(), person.getName(), person.getLocation(), person.getBirthday());
    }

    public int update(Person person){
        return jdbcTemplate.update("update person set name = ?, location = ?, birthday = ?  where id = ? ",
                person.getName(), person.getLocation(), person.getBirthday(), person.getId());
    }

}
