package com.example.database.dao;

import com.example.database.model.Person;
import com.example.database.util.CustomRowMapper;
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

    public List<Person> findAllWithCustomRowMapper(){
        return jdbcTemplate.query("select * from person", CustomRowMapper.personRowMapper);
    }

    public Person findById(int id){
        return jdbcTemplate.queryForObject("select * from person where id = ?",
                new BeanPropertyRowMapper<>(Person.class),
                id);
    }

    public Person findByIdWithCustomRowMapper(int id){
        return jdbcTemplate.queryForObject("select * from person where id = ?",
                CustomRowMapper.personRowMapper,
                id);
    }

    public List<Person> findByName(String name){
        return jdbcTemplate.query("select * from person where name = ?",
                new BeanPropertyRowMapper<>(Person.class),
                name);
    }

    public List<Person> findByNameWithCustomRowMapper(String name){
        return jdbcTemplate.query("select * from person where name = ?",
                CustomRowMapper.personRowMapper,
                name);
    }

    public Person findByNameAndLocation(String name, String location){
        return jdbcTemplate.queryForObject("select * from person where name = ? and location = ?",
                new BeanPropertyRowMapper<>(Person.class),
                name, location);
    }

    public Person findByNameAndLocationWithCustomRowMapper(String name, String location){
        return jdbcTemplate.queryForObject("select * from person where name = ? and location = ?",
                CustomRowMapper.personRowMapper,
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
