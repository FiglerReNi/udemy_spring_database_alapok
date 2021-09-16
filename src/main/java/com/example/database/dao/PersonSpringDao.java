package com.example.database.dao;

import com.example.database.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonSpringDao extends JpaRepository<Person, Integer> {


}
