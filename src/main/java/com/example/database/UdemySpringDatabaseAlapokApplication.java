package com.example.database;

import com.example.database.dao.PersonDao;
import com.example.database.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;


@SpringBootApplication
public class UdemySpringDatabaseAlapokApplication implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private PersonDao personDao;

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(UdemySpringDatabaseAlapokApplication.class, args);
    }

    @Override
    public void run(String... args) {
         logger.info("All users -> {}",  personDao.findAll());
         logger.info("User id 2 -> {}",  personDao.findById(2));
         logger.info("User name James -> {}",  personDao.findByName("James"));
         logger.info("User name James, location Budapest -> {}",  personDao.findByNameAndLocation("James", "Budapest"));
         logger.info("Deleting 1 -> Number of rows deleted  {}",  personDao.deleteById(1));
         logger.info("Insert 5 -> Number of rows inserted  {}",  personDao.insert(new Person(5, "John", "Berlin", LocalDate.of(1990, 8, 26))));
         logger.info("Update 2 -> Number of rows updated  {}",  personDao.update(new Person(2, "Pieter", "Köln", LocalDate.of(1993, 10, 26) )));
    }
}
