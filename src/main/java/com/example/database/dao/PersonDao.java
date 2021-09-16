package com.example.database.dao;

import com.example.database.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<Person> findAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(long id){
        return entityManager.find(Person.class, id);
    }

    public Person updateAndInsert(Person person){
        return entityManager.merge(person);
    }

    public void deleteById(long id){
        Person person = findById(id);
        entityManager.remove(person);
    }
}
