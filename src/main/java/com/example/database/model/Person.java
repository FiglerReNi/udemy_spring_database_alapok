package com.example.database.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//@Table(name="person")
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    //@Column(name="name")
    private String name;
    private String location;
    private LocalDate birthday;

    public Person(String name, String location, LocalDate birthday) {
        this.name = name;
        this.location = location;
        this.birthday = birthday;
    }

}
