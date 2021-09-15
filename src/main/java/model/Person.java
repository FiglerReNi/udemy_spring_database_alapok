package model;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    private int id;
    private String name;
    private String location;
    private LocalDate birthday;
}
