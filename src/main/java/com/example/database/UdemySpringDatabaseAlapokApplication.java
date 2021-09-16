package com.example.database;

import com.example.database.dao.PersonSpringDao;
import com.example.database.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;

@SpringBootApplication
public class UdemySpringDatabaseAlapokApplication implements CommandLineRunner{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private PersonSpringDao personSpringDao;

    @Autowired
    public void setPersonSpringDao(PersonSpringDao personSpringDao) {
        this.personSpringDao = personSpringDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(UdemySpringDatabaseAlapokApplication.class, args);
    }

    @Override
    public void run(String... args) {
         logger.info("All users -> {}",  personSpringDao.findAll());
         logger.info("User id 2 -> {}",  personSpringDao.findById(2));
         logger.info("Insert ->  {}",  personSpringDao.save(new Person("John", "Berlin", LocalDate.of(1990, 8, 26))));
         logger.info("Update 2 -> {}",  personSpringDao.save(new Person(2, "Pieter", "Köln", LocalDate.of(1993, 10, 26) )));
         personSpringDao.deleteById(1);
   }
}
