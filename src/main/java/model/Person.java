package model;

import lombok.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    private int id;
    private String name;
    private String location;
    private Date birthday;
}
